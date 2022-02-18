package entity;

import java.util.ArrayList;
import java.util.List;

public class Journal {
    public String journal_title;
    public Contacts contacts;
    List<Article> articles;

    public String getJournal_title() {
        return journal_title;
    }

    public void setJournal_title(String journal_title) {
        this.journal_title = journal_title;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "journal_title='" + journal_title + '\'' +
                ", contacts=" + contacts +
                ", articles=" + articles +
                '}';
    }
}
