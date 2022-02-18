package dom;

import entity.Article;
import entity.Contacts;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParserArticle {

    public static List<Article> articles = new ArrayList<>();

    public static Article setArticlesWithXMLChildNodeValue(Article article, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {

            case "title":
                article.setTitle(content);
            case "author":
                article.setAuthor(content);
            case "url":
                article.setUrl(content);
                break;
            case "hotkey":
                article.setHotkeys(article.getHotkeys());
        }
       return article;
    }

    public static void setArticleWithXMLNodeValues(NodeList nodeList) {

        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                Article article = new Article();
                setArticlesWithXMLChildNodeValue(article, node);
                article.setId(node.getAttributes().
                        getNamedItem("ID").getNodeValue());

                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setArticlesWithXMLChildNodeValue(article, childNode);
                    }
                });
                articles.add(article);
            }
        });
    }
}



