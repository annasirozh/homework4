package dom;

import entity.Journal;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParserJournal {
    public static List<Journal> journals = new ArrayList<>();

    public static Journal setTitleWithXMLChildNodeValues(Journal journal, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {

            case "journal_title":
                journal.setJournal_title(content);
        }
        return journal;
    }

    public static void setTitleWithXMLNodeValues(NodeList nodeList) {

        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            Journal journal = new Journal();
            if (node instanceof Element) {
                setTitleWithXMLChildNodeValues(journal, node);
                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setTitleWithXMLChildNodeValues(journal, childNode);
                    }
                });
                journals.add(journal);
            }
        });
    }

}
