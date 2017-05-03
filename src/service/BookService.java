package service;

import model.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class BookService {

  //  List<Book> books = new ArrayList<Book>();

    public static void addBook(Book book) {
        Document doc = null;
        try {
            File xmlFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            Element initialDoc = doc.getDocumentElement();
            Element element = doc.createElement("book");
            initialDoc.appendChild(element);

            Element title = doc.createElement("title");
            title.setTextContent(book.getTitle());
            element.appendChild(title);

            Element author = doc.createElement("author");
            author.setTextContent(book.getAuthor());
            element.appendChild(author);

            Element gender = doc.createElement("gender");
            gender.setTextContent(book.getGendre());
            element.appendChild(gender);

            Element quantity = doc.createElement("quantity");
            quantity.setTextContent(String.valueOf(book.getQuantity()));
            element.appendChild(quantity);

            Element price = doc.createElement("price");
            price.setTextContent(String.valueOf(book.getPrice()));
            element.appendChild(price);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, new StreamResult(new File("books.xml")));
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }

    }

    public static void updateBook(String title, Book book) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("books.xml"));

            NodeList nList = document.getElementsByTagName("book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("title").item(0).getTextContent().equals(title)) {
                        element.getElementsByTagName("quantity").item(0).setTextContent((String.valueOf(book.getQuantity())));
                        element.getElementsByTagName("price").item(0).setTextContent((String.valueOf(book.getPrice())));
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(new File("books.xml")));

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }

    }

    public static void deleteBook(String title) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("books.xml"));

            NodeList nList = document.getElementsByTagName("book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("title").item(0).getTextContent().equals(title)) {
                        element.getParentNode().removeChild(element);
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(new File("books.xml")));

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Book> searchByGenre(String gender) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("books.xml"));
            NodeList nList = document.getElementsByTagName("book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("gender").item(0).getTextContent().equals(gender)) {
                        String title = element.getElementsByTagName("title").item(0).getTextContent();
                        String author = element.getElementsByTagName("author").item(0).getTextContent();
                        String gender1 = element.getElementsByTagName("gender").item(0).getTextContent();
                        String quantityString = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String priceString = element.getElementsByTagName("price").item(0).getTextContent();
                        int quantity = Integer.parseInt(quantityString);
                        int price = Integer.parseInt(priceString);
                        Book book = new Book(title, author, gender1, quantity, price);
                        books.add(book);
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("books.xml"));
            NodeList nList = document.getElementsByTagName("book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("title").item(0).getTextContent().equals(title)) {
                        String title1 = element.getElementsByTagName("title").item(0).getTextContent();
                        String author = element.getElementsByTagName("author").item(0).getTextContent();
                        String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                        String quantityString = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String priceString = element.getElementsByTagName("price").item(0).getTextContent();
                        int quantity = Integer.parseInt(quantityString);
                        int price = Integer.parseInt(priceString);
                        Book book = new Book(title1, author, gender, quantity, price);
                        books.add(book);
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("books.xml"));
            NodeList nList = document.getElementsByTagName("book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("author").item(0).getTextContent().equals(author)) {
                        String title = element.getElementsByTagName("title").item(0).getTextContent();
                        String author1 = element.getElementsByTagName("author").item(0).getTextContent();
                        String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                        String quantityString = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String priceString = element.getElementsByTagName("price").item(0).getTextContent();
                        int quantity = Integer.parseInt(quantityString);
                        int price = Integer.parseInt(priceString);
                        Book book = new Book(title, author1, gender, quantity, price);
                        books.add(book);
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static ArrayList<Book> stock(){
        ArrayList<Book> books = new ArrayList<>();
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("books.xml"));

            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("quantity").item(0).getTextContent().equalsIgnoreCase("0"))
                    {
                        String title = element.getElementsByTagName("title").item(0).getTextContent();
                        String author = element.getElementsByTagName("author").item(0).getTextContent();
                        String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                        String quantityString = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String priceString = element.getElementsByTagName("price").item(0).getTextContent();
                        int quantity = Integer.parseInt(quantityString);
                        int price = Integer.parseInt(priceString);
                        Book book = new Book(title,author,gender,quantity,price);
                        books.add(book);
                    }
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return books;

    }


        public static void sell(Book book,int quantity) {
        try {
            List<Book> books = searchByTitle(book.getTitle());
            for (Book book1 : books) {
                if (book1.getQuantity() >= quantity) {
                    book1.setQuantity(book1.getQuantity() - quantity);
                    updateBook(book1.getTitle(), book1);

                    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = builderFactory.newDocumentBuilder();
                    Document document = builder.parse(new FileInputStream("sell.xml"));
                    Element initialDoc = document.getDocumentElement();
                    Element element = document.createElement("sell");
                    initialDoc.appendChild(element);

                    Element title = document.createElement("title");
                    title.setTextContent(book1.getTitle());
                    element.appendChild(title);

                    Element author = document.createElement("author");
                    author.setTextContent(book1.getAuthor());
                    element.appendChild(author);

                    Element gender = document.createElement("gender");
                    gender.setTextContent(book1.getGendre());
                    element.appendChild(gender);

                    Element quantity1 = document.createElement("quantity");
                    quantity1.setTextContent(String.valueOf(quantity));
                    element.appendChild(quantity1);

                    Element price = document.createElement("price");
                    price.setTextContent(String.valueOf(book1.getPrice()));
                    element.appendChild(price);

                    Element sum = document.createElement("sum");
                    sum.setTextContent(String.valueOf(book1.getPrice() * quantity));
                    element.appendChild(sum);

                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.transform(new DOMSource(document), new StreamResult(new File("sell.xml")));
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
}