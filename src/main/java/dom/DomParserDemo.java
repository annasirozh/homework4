package dom;

import entity.Article;
import entity.Contacts;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParserDemo {

    private static final String XML_PATH = "journal.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Document document = DOMParserUtils.parseXMLDocument(XML_PATH);

        //Output journal_title
        NodeList nodeJournalTitle = document.getElementsByTagName("journal_title");
        DOMParserJournal.setTitleWithXMLNodeValues(nodeJournalTitle);
        System.out.println(DOMParserJournal.journals.toString());

        //Output contacts
        NodeList nodeContacts = document.getElementsByTagName("contacts");
        DOMParserContact.setContactsWithXMLNodeValues(nodeContacts);
        System.out.println(DOMParserContact.contacts.toString());


       //Output articles
        NodeList nodeArticles = document.getElementsByTagName("articles");
        DOMParserArticle.setArticleWithXMLNodeValues(nodeArticles);
        System.out.println(DOMParserArticle.articles.toString());

        //Output hotkeys
        NodeList nodeHotkeys = document.getElementsByTagName("hotkeys");
        DOMParserHotkey.setHotkeyWithXMLNodeValues(nodeHotkeys );
        System.out.println(DOMParserHotkey.hotkeys.toString());


    }
}
