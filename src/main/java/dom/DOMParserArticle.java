package dom;

import entity.Article;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParserArticle {
    public static List<Article> articles = new ArrayList<>();

    public static Article setArticleWithXMLChildNodeValues (Article article, Node node){
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "title"-> article.setTitle(content);
            case "author" -> article.setAuthor(content);
            case "url" -> article.setUrl(content);
            case "hotkey" -> article.setHotkeys(article.getHotkeys());
        }
        return article;
    }

    public static void setArticleWithXMLNodeValues (NodeList nodeList){
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                Article article = new Article();
                article.setId(node.getAttributes().getNamedItem("ID").getNodeValue());

                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setArticleWithXMLChildNodeValues(article, childNode);
                    }
                });
                articles.add(article);
            }
        });
    }
}
