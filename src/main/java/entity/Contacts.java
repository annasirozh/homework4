package entity;

public class Contacts {
    public String address;
    public String tel;
    public String email;
    public String journal_url;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJournal_url() {
        return journal_url;
    }

    public void setJournal_url(String journal_url) {
        this.journal_url = journal_url;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", journal_url='" + journal_url + '\'' +
                '}';
    }
}
