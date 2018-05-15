package ad.poc.jaxb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
 
public class JAXBDemo {
    public static void main(String[] args) {
        Book book = new Book();
        book.setAuthor("Kathy Sierra");
        book.setName("SCJP");
        book.setPublisher("Tata McGraw Hill");
        book.setIsbn("856-545456736");
         
        Book book1 = new Book();
        book1.setAuthor("Christian Bauer");
        book1.setName("Java Persistence with Hibernate");
        book1.setPublisher("Manning");
        book1.setIsbn("978-3832180577");
         
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        books.add(book1);
        //Marshalling: Writing Java objects to XMl file
        try {
            JAXBXMLHandler.marshal(books, new File("books.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
         
        //Unmarshalling: Converting XML content to Java objects
        try {
            books = JAXBXMLHandler.unmarshal(new File("books.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(books);
    }
}
