package ad.cass.poc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBException;
 
public class ExerciserDocument  {
	
	/**
	 * Convert XML file to Java Object, and save a pdfFile, stored inside the java Object, to the filesystem
	 * @throws IOException 
	 */
    public static void main(String[] args) throws Exception {
        
		System.out.println("START (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") method");
		
        Document doc = new Document();
         
        try {
            doc = JAXBXMLHandler.unmarshalDocument(new File("src/main/resources/document.metadata.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
		String fileName = "src/main/resources/" + doc.getId(); 
		Files.write(Paths.get(fileName), doc.getContent());

		System.out.println("FINISH (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") method");
        
    }
	
}
