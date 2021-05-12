public class Booky {
    private int id;
    private String name = "-";
    private String author = "-";
    private String img = "-";
    private double rate = 250/100.0;
    private String genre = "-";
    private String description = "-";
    private String country = "-";
    private int year = 0;
    private boolean approved = false;


    public Booky(String book_name, String img_url, String book_description, String book_country, int book_date) {
        this.name = book_name;
        this.img = img_url;
        this.description = book_description;
        this.country = book_country;
        this.year = book_date;
        BDB bdb = BDB.get_instance();

    }
    public Booky(int id, String book_name, String img_url, String book_description, String book_country, int book_date) {
        this.id = id;
        this.name = book_name;
        this.img = img_url;
        this.description = book_description;
        this.country = book_country;
        this.year = book_date;
    }

    public String content_string(){
        return name+","+img+","+description+","+country+","+year+"\n";
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
}
