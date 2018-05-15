package ad.poc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

public class JPEG2PDFPoc {

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {

		System.out.println("Processant...");
		JPEG2PDFPoc jpg2pdf = new JPEG2PDFPoc();
		jpg2pdf.doTheJob();
		System.out.println("OK");

	}

	/**
	 * Read two jpg files and save it in one pdf file
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	private void doTheJob() throws DocumentException, MalformedURLException, IOException {

		// creation of the document with a certain size and certain margins
		Document document = new Document(PageSize.A4, 5, 5, 5, 5);

		// creation of the different writers
		PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/output/jpg2pdf.pdf"));
		
		document.open();

		// Imatge01 petita, no modificar. El -10 es el marge.

		//Image imatge01 = Image.getInstance("src/main/resources/img/imatge01.jpg");
		byte[] imatge01Bytes = Files.readAllBytes(new File("src/main/resources/input/imatge01.jpg").toPath());
		Image imatge01 = Image.getInstance(imatge01Bytes);
		
		if (imatge01.getWidth() > (PageSize.A4.getWidth() - 10) || imatge01.getHeight() > (PageSize.A4.getHeight() - 10))
			imatge01.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
		document.add(imatge01);

		// Imatge02 gran, modificar.

		//Image imatge02 = Image.getInstance("src/main/resources/input/imatge02.jpg");
		byte[] imatge02Bytes = Files.readAllBytes(new File("src/main/resources/input/imatge02.jpg").toPath());
		Image imatge02 = Image.getInstance(imatge02Bytes);
		
		imatge02.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
		document.add(imatge02);
		
		document.close();
	}

}
