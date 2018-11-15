package ad.cass.poc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

public class ExerciserOCR {

	public static void main(String[] args) throws Exception {
		System.out.println("Inici");
		ExerciserOCR exerciser = new ExerciserOCR();
		exerciser.doTheJob();
		System.out.println("Fi");
	}

	private void doTheJob() throws Exception {
		readBarCodeImage();
		readQRCodeImage();
	}

	private void readQRCodeImage() throws Exception {
		QRCodeReader reader = new QRCodeReader();
		BufferedImage image = ImageIO.read(new File("src/main/resources/qrCode.png"));
		LuminanceSource source = new BufferedImageLuminanceSource(image);
		Binarizer binarizer = new HybridBinarizer(source);
		BinaryBitmap imageBinaryBitmap = new BinaryBitmap(binarizer);
		Result result = reader.decode(imageBinaryBitmap);
		System.out.println("qrCode decode: " + result.getText());
	}

	private void readBarCodeImage() throws Exception {
		InputStream barCodeInputStream = new FileInputStream("src/main/resources/barCode.png");
		BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);
		LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		MultiFormatReader reader = new MultiFormatReader();
		Result result = reader.decode(bitmap);
		System.out.println("barCode decode: " + result.getText());
	}

}
