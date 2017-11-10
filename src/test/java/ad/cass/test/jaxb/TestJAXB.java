package ad.cass.test.jaxb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;

import org.junit.Test;

import ad.cass.test.jaxb.JAXBXMLHandler;
import junit.framework.TestCase;
 
public class TestJAXB extends TestCase  {
	
	/**
	 * Convert XML file to Java Object, and save a pdfFile, stored inside the java Object, to the filesystem
	 * @throws IOException 
	 */
	@Test
    public void testMarshall() throws IOException {
        
		System.out.println("START (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") method");
		
        Document doc = new Document();
         
        try {
            doc = JAXBXMLHandler.unmarshal(new File("src/test/resources/input/document.metadata.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
		String fileName = "src/test/resources/output/" + doc.getId(); 
		Files.write(Paths.get(fileName), doc.getContent());

		System.out.println("FINISH (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") method");
        
    }
	
}
