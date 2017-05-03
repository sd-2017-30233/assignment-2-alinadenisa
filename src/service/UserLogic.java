package service;

import model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class UserLogic {
    public static void addUser(User user) {
        Document doc = null;
        try {
            File xmlFile = new File("users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            Element initialDoc = doc.getDocumentElement();
            Element element = doc.createElement("user");
            initialDoc.appendChild(element);

            Element username = doc.createElement("username");
            username.setTextContent(user.getUsername());
            element.appendChild(username);

            Element name = doc.createElement("name");
            name.setTextContent(user.getName());
            element.appendChild(name);

            Element password = doc.createElement("password");
            password.setTextContent(user.getPassword());
            element.appendChild(password);

            Element isAdmin = doc.createElement("admin");
            isAdmin.setTextContent(String.valueOf(user.isAdmin()));
            element.appendChild(isAdmin);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, new StreamResult(new File("users.xml")));
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }

    }

    public static void updateUser(String username,User user) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("users.xml"));

            NodeList nList = document.getElementsByTagName("user");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("username").item(0).getTextContent().equals(username)) {
                        element.getElementsByTagName("password").item(0).setTextContent(user.getPassword());
                        element.getElementsByTagName("name").item(0).setTextContent(user.getName());
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(new File("users.xml")));

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(String username) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("users.xml"));

            NodeList nList = document.getElementsByTagName("user");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("username").item(0).getTextContent().equals(username)) {
                        element.getParentNode().removeChild(element);
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(new File("users.xml")));

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static boolean isUserAdmin(String username) {
        boolean admin = false;
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("users.xml"));

            NodeList nList = document.getElementsByTagName("user");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (Boolean.valueOf(element.getElementsByTagName("admin").item(0).getTextContent())) {
                        admin = true;
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return admin;

    }
}
