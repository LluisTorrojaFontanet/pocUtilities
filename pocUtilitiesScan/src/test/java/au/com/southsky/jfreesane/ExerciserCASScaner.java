package au.com.southsky.jfreesane;

// https://github.com/sjamesr/jfreesane

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
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

@RunWith(JUnit4.class)
public class ExerciserCASScaner {

	private static final Logger log = Logger.getLogger(ExerciserCASScaner.class.getName());
	private SaneSession session;
	private SaneDevice device;

	@Test
	public void scan() throws Exception {
		log.info("Inici");

		// Iniciar sessió
		HostAndPort hostAndPort = HostAndPort.fromString("192.168.25.127");
		this.session = SaneSession.withRemoteSane(InetAddress.getByName(hostAndPort.getHostText()),
				hostAndPort.getPortOrDefault(6566));

		// Llista dispositiu 1er
		List<SaneDevice> devices = session.listDevices();
		log.info("Got " + " device: " + devices.get(0));

		// Obrir dispositiu 1er
		device = session.getDevice(devices.get(0).getName());
		device.open();
		log.info("Device '" + devices.get(0).getName() + "' opened");
		device.close();
		log.info("Device '" + devices.get(0).getName() + "' closed");

		// List options
//		device.open();
//		log.info("");
//		List<SaneOption> options = device.listOptions();
//		for (Iterator iterator = options.iterator(); iterator.hasNext();) {
//			SaneOption saneOption = (SaneOption) iterator.next();
//			log.info("Option '" + saneOption);
//		}
//		device.close();
		
		// Set color
//		SaneOption modeOption = device.getOption("mode");
//		modeOption.setStringValue("Gray");
//		SaneOption modeOption = device.getOption("mode");
//		modeOption.setStringValue("Color");
//		log.info("color set succeful");

		// De moment no se fer-ho els dos a la vegada ja que em diu scaner busy. 
		// Com a Poc inicial ja es correcte. merakifx-scan aprofundirà en tots els temes d'scaneig
		
		// Scan en gris pla 1 pàgina
//		acquireMonoImageFlat();
//		log.info("acquireMonoImageFlat succesful");

		// Scan en gris alimentador 1 pàgina
		acquireMonoImageAutoFeeder();
		log.info("acquireMonoImageAutoFeeder succesful");

		// Tancar sessió
		Closeables.close(session, false);
		
		log.info("Fi");
	}

	private void acquireMonoImageFlat() throws Exception {
		device.open();
		//device.getOption("source").setStringValue("ADF Duplex");
		BufferedImage image = device.acquireImage();
		File file = File.createTempFile("mono-image-flat", ".png", new File("src/test/resources"));
		ImageIO.write(image, "png", file);
		device.close();
	}

	private void acquireMonoImageAutoFeeder() throws Exception {
		device.open();

		device.getOption("source").setStringValue("ADF Duplex");

		BufferedImage image = device.acquireImage();
		File file = File.createTempFile("mono-image-feeder", ".png", new File("src/test/resources"));
		ImageIO.write(image, "png", file);
		device.close();
	}

	private void acquireMonoImageAutoFeederMulti() throws Exception {
		device.open();

		device.getOption("source").setStringValue("ADF Duplex");

		BufferedImage image;
		File file = File.createTempFile("mono-image-feeder", ".png", new File("src/test/resources"));
		for (int i = 0; i < 20; i++) {
			try {
				image = device.acquireImage();
				ImageIO.write(image, "png", file);
			} catch (SaneException e) {
				if (e.getStatus() == SaneStatus.STATUS_NO_DOCS) {
					// out of documents to read, that's fine
					break;
				} else {
					throw e;
				}
			} finally {
				device.close();
			}
		}
		device.close();

	}

}
