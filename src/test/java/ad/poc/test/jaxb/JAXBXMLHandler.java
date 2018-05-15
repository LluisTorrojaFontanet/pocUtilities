package ad.poc.test.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBXMLHandler {

	public static Document unmarshal(File importFile) throws JAXBException {
		Document doc = new Document();

		JAXBContext context = JAXBContext.newInstance(Document.class);
		Unmarshaller um = context.createUnmarshaller();
		doc = (Document) um.unmarshal(importFile);

		return doc;
	}
}