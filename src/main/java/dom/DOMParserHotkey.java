package dom;

import entity.Hotkeys;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParserHotkey {
    public static List<Hotkeys> hotkeys = new ArrayList<>();

    public static Hotkeys setHotkeyWithXMLChildNodeValues(Hotkeys hotkey, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {

            case "hotkey":
                hotkey.setHotkey(content);
        }
        return hotkey;
    }
    public static void setHotkeyWithXMLNodeValues(NodeList nodeList) {
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            Hotkeys hotkey = new Hotkeys();
            if (node instanceof Element) {
                setHotkeyWithXMLChildNodeValues(hotkey, node);
                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setHotkeyWithXMLChildNodeValues(hotkey, childNode);
                    }
                });
                hotkeys.add(hotkey);
            }
        });
    }
}
