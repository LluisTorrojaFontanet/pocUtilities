package au.com.southsky.jfreesane;

// https://github.com/sjamesr/jfreesane

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.google.common.io.Closeables;
import com.google.common.net.HostAndPort;

import ad.au.com.southsky.jfreesane.SaneDevice;
import ad.au.com.southsky.jfreesane.SaneException;
import ad.au.com.southsky.jfreesane.SaneSession;
import ad.au.com.southsky.jfreesane.SaneStatus;

@RunWith(JUnit4.class)
public class ExerciserCASScanerEK {

	private static final Logger log = Logger.getLogger(ExerciserCASScanerEK.class.getName());
	private SaneSession session;
	private SaneDevice deviceSelected;
	private BufferedImage bufImage;

	@Test
	public void scan() {
		log.info("Inici");

		try {

			// Iniciar sessió
			this.session = SaneSession.withRemoteSane(InetAddress.getByName("scanner03"), 6566);

			// Llista dispositiu 1er
			List<SaneDevice> devices = session.listDevices();

			// Scan en gris pla 1 pàgina
			deviceSelected = session.getDevice(devices.get(0).getName());
			scan2();
			log.info("scan01 succesful");
			deviceSelected = session.getDevice(devices.get(0).getName());
			scan2();
			log.info("scan02 succesful");

			// Tancar sessió
			Closeables.close(session, false);

			log.info("Fi");

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				Closeables.close(session, false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void scan2() throws Exception {
		// SaneDevice device = deviceListView.getSelectionModel().getSelectedItem();
		/*
		 * deviceSelected = deviceListView.getSelectionModel().getSelectedItem(); ultimDeviceSelected = deviceSelected;
		 */
		// BufferedImage bufImage = null;
		bufImage = null;
		// deviceSelected = device;
		if (deviceSelected == null) {
			// Hay que seleccionar
			System.out.println("No hay scaner seleccionado");
		} else {
			if (deviceSelected.isOpen()) {

			} else {
				deviceSelected.open();
			}

			// valors per defectes
			deviceSelected.getOption("resolution").setIntegerValue(150);
			deviceSelected.getOption("mode").setStringValue("Gray");
			deviceSelected.getOption("sleeptimer").setIntegerValue(0);
			deviceSelected.getOption("buffermode").setStringValue("On");
			deviceSelected.getOption("swskip").setFixedValue(25.00);
			log.info("OptionsSane: per defecte (Default) ");

			// modificació de la safata d'entrada
			/*
			 * if(optionsSane.isEmpty() || optionsSane.length() == 0) { }else {//sembla que s'ha de fer aqui l'actualització de l'opció
			 * deviceSelected.getOption("source").setStringValue(optionsSane); log.info("OptionsSane:" + optionsSane); }
			 * 
			 * //modificació de la resolution if(optionsSaneResolution == 0) { }else {//sembla que s'ha de fer aqui l'actualització de l'opció
			 * deviceSelected.getOption("resolution").setIntegerValue(optionsSaneResolution); log.info("OptionsSaneResolution:" + optionsSaneResolution); }
			 * 
			 * //modificació del color if(optionsSaneColor.isEmpty() || optionsSaneColor.length() == 0) { }else {//sembla que s'ha de fer aqui l'actualització
			 * de l'opció deviceSelected.getOption("mode").setStringValue(optionsSaneColor); log.info("OptionsSaneColor:" + optionsSaneColor); }
			 */

			// scaneig
			if (deviceSelected.getOption("source").getStringValue().equals("Flatbed")) {
				acquireMonoImageFlat();
			} else {
				acquireMonoImageAutoFeeder();
			}

		}

	}

	private void acquireMonoImageFlat() throws Exception {
		// BufferedImage bufImage = deviceSelected.acquireImage();
		try {
			// deviceSelected.open();
			// BufferedImage bufImage = deviceSelected.acquireImage();
			bufImage = deviceSelected.acquireImage();
			// EK
			/*Image image = SwingFXUtils.toFXImage(bufImage, null);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(600);// 600
			imageView.setFitWidth(600);// 600
			imageView.setPreserveRatio(true);
			preview.setContent(imageView); // solo para ver la llista de documents escaneijats

			// pagination
			pagination.setPageCount(1);
			currentImage = imageView;
			pageImage = new ImageView[1];
			pageImage[0] = currentImage;*/
			// preview.contentProperty().setValue(currentImage); //solo para ver la llista de documents escaneijats
			// createPaginationPageFactory();
			log.info("acquireMonoImageFlat succeful");

		} catch (Exception e) {
			e.printStackTrace();
		}

		/* *****************************************segona proposta*************************************************** */
		/*String fileDest = System.getProperty("java.io.tmpdir") + "/scan/"; // "/scan/capture.pdf"
		byte[] pdfBytes = toByteArrayAutoClosable(bufImage, "png");
		writeBytesToFile(pdfBytes, fileDest);*/

		deviceSelected.close();
		deviceSelected = null;

		// Closeables.close(session, false);
		// }
	}

	private void acquireMonoImageAutoFeeder() throws Exception {
		/*List<Image> AllImages = new LinkedList();
		// BufferedImage bufImage;
		ImageView imageView[];*/
		// File file = File.createTempFile("multi-image", ".png", new File("/tmp/scan"));
		for (int i = 0; i < 100; i++) {
			try {
				bufImage = deviceSelected.acquireImage();
				/*Image image = SwingFXUtils.toFXImage(bufImage, null);
				AllImages.add(image);*/
			} catch (SaneException e) {
				if (e.getStatus() == SaneStatus.STATUS_NO_DOCS) {
					// out of documents to read, that's fine
					break;
				}

			}

		}
		// pagination
		/*imageView = new ImageView[AllImages.size()];
		// log.info("allImages Size"+ AllImages.size());
		for (int j = 0; j < imageView.length; j++) {
			imageView[j] = new ImageView(AllImages.get(j));
			imageView[j].setFitHeight(600);
			imageView[j].setFitWidth(600);
			imageView[j].setSmooth(true);
			imageView[j].setPreserveRatio(true);
		}

		pageImage = imageView;
		pagination.setPageCount(AllImages.size());
		// pagination.setCurrentPageIndex(1);*/
		
			log.info("acquireMonoImageAutoFeeder() succeful");
		
		deviceSelected.close();
		// }

	}

}
