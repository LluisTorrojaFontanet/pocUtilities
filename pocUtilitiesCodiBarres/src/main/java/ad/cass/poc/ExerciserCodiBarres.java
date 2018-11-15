package ad.cass.poc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ExerciserCodiBarres {

	public static void main(String[] args) throws Exception {
		System.out.println("Inici");
		ExerciserCodiBarres exerciser = new ExerciserCodiBarres();
		exerciser.doTheJob("Hola soc un codi");
		System.out.println("Fi");
	}

	private void doTheJob(String codi) throws Exception {
		createBarCode(codi + " de barres en format PNG");
		createQRCode(codi + " QR en format PNG");
	}

	private void createQRCode(String codi) throws Exception {
		byte[] ret = null;

		BufferedImage imageBarCode = getQrCodeImage(codi);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(imageBarCode, "png", baos);
		baos.flush();
		ret = baos.toByteArray();
		baos.close();

		File barCodeImage = new File("src/main/resources/qrCode.png");
		OutputStream out;
		out = new java.io.FileOutputStream(barCodeImage);
		out = new java.io.BufferedOutputStream(out);
		FileOutputStream str = new FileOutputStream(barCodeImage);
		str.write(ret);
		str.close();
		out.close();
	}

	private BufferedImage getQrCodeImage(String codi) throws Exception {
		int size = 280;

		Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

		// Now with zxing version 3.2.1 you could change border size (white border size
		// to just 1)
		hintMap.put(EncodeHintType.MARGIN, 0); /* default = 4 */
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(codi, BarcodeFormat.QR_CODE, size, size, hintMap);
		int CrunchifyWidth = byteMatrix.getWidth();
		BufferedImage imageQR = new BufferedImage(CrunchifyWidth, CrunchifyWidth, BufferedImage.TYPE_BYTE_GRAY);
		imageQR.createGraphics();

		Graphics2D graphics = (Graphics2D) imageQR.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < CrunchifyWidth; i++) {
			for (int j = 0; j < CrunchifyWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		return imageQR;
	}

	private void createBarCode(String codi) throws Exception {
		byte[] ret = null;

		BufferedImage imageBarCode = getBarCodeImage(codi);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(imageBarCode, "png", baos);
		baos.flush();
		ret = baos.toByteArray();
		baos.close();

		File barCodeImage = new File("src/main/resources/barCode.png");
		OutputStream out;
		out = new java.io.FileOutputStream(barCodeImage);
		out = new java.io.BufferedOutputStream(out);
		FileOutputStream str = new FileOutputStream(barCodeImage);
		str.write(ret);
		str.close();
		out.close();
	}

	private BufferedImage getBarCodeImage(String codi) throws WriterException {

		int width = 580;
		int height = 236;

		Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

		// Now with zxing version 3.2.1 you could change border size (white border size
		// to just 1)
		hintMap.put(EncodeHintType.MARGIN, 0); /* default = 4 */
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);

		MultiFormatWriter barCodeWriter = new MultiFormatWriter();
		BitMatrix byteMatrix = barCodeWriter.encode(codi, BarcodeFormat.CODE_128, width, height, hintMap);
		int crunchifyWidth = byteMatrix.getWidth();
		int crunchifyHeight = byteMatrix.getHeight();
		BufferedImage imageBarCode = new BufferedImage(crunchifyWidth, crunchifyHeight, BufferedImage.TYPE_BYTE_GRAY);
		imageBarCode.createGraphics();

		Graphics2D graphics = (Graphics2D) imageBarCode.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, crunchifyWidth, crunchifyHeight);
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < crunchifyWidth; i++) {
			for (int j = 0; j < crunchifyHeight; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}

		return imageBarCode;

	}

}
