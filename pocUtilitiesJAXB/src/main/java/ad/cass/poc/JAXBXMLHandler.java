package ad.cass.poc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBXMLHandler {

	// Export
	public static void marshalListBook(List<Book> books, File selectedFile) throws IOException, JAXBException {
		JAXBContext context;
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(selectedFile));
		context = JAXBContext.newInstance(Books.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(new Books(books), writer);
		writer.close();
	}

	// Import
	public static List<Book> unmarshalBookList(File importFile) throws JAXBException {
		Books books = new Books();

		JAXBContext context = JAXBContext.newInstance(Books.class);
		Unmarshaller um = context.createUnmarshaller();
		books = (Books) um.unmarshal(importFile);

		return books.getBooks();
	}
	
	public static Document unmarshalDocument(File importFile) throws JAXBException {
		Document doc = new Document();

		JAXBContext context = JAXBContext.newInstance(Document.class);
		Unmarshaller um = context.createUnmarshaller();
		doc = (Document) um.unmarshal(importFile);

		return doc;
	}
}