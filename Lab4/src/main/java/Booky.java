import java.util.ArrayList;
import java.util.List;

public class Booky {
    private int id;
    private String name = "-";
    private String author = "-";
    private String img_URL = "-";
    private String publishing = "-";
    private double rate = 0;
    private String genre = "-";
    private String description = "-";
    private String country = "-";
    private int year = 0;
    private boolean approved = false;
    private List<User> who_has = new ArrayList<>();


    public Booky(
            String book_name,
            String author,
            String img_url,
            String publishing,
            String genre,
            String book_description,
            String book_country,
            int book_date) {
        this.name = book_name;
        this.author = author;
        this.img_URL = img_url;
        this.publishing = publishing;
        this.genre = genre;
        this.description = book_description;
        this.country = book_country;
        this.year = book_date;
        DataBase dataBase = DataBase.get_instance();

    }
    public Booky(
            int id,
            String book_name,
            String author,
            String img_url,
            String publishing,
            String genre,
            String book_description,
            String book_country,
            int book_date) {
        this.id = id;
        this.name = book_name;
        this.author = author;
        this.img_URL = img_url;
        this.publishing = publishing;
        this.genre = genre;
        this.description = book_description;
        this.country = book_country;
        this.year = book_date;
    }

    public String content_string(){
        return name+","+ img_URL +","+description+","+country+","+year+"\n";
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_URL() {
        return img_URL;
    }

    public void setImg_URL(String img_URL) {
        this.img_URL = img_URL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public List<User> getWho_has() {
        return who_has;
    }

    public void setWho_has(List<User> who_has) {
        this.who_has = who_has;
    }
}
