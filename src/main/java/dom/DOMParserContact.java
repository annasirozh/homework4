package dom;

import entity.Contacts;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParserContact {
    public static List<Contacts> contacts = new ArrayList<>();

    public static Contacts setContactsWithXMLChildNodeValues(Contacts contact, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "address":
                contact.setAddress(content);
            case "tel":
                contact.setTel(content);
            case "email":
                contact.setEmail(content);
            case "journal_url":
                contact.setJournal_url(content);
                break;
        }
        return contact;
    }

    public static void setContactsWithXMLNodeValues(NodeList nodeList) {
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            Contacts contact = new Contacts();
            if (node instanceof Element) {
                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setContactsWithXMLChildNodeValues(contact, childNode);
                    }
                });
                contacts.add(contact);
            }
        });
    }
}
