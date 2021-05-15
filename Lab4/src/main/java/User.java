import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String login;
    private String password;
    private String nickname;
    private String avatar_URL;
    private int number = 0;
    private double rate = 0;
    private int book_counter = 0;
    private int[] books_id = new int[book_counter];

    public User(){}

    public User(
            int id,
            String login,
            String password,
            String nickname,
            String avatar_URL){
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.avatar_URL = avatar_URL;
    }
    public User(
            String login,
            String password,
            String nickname,
            String avatar_URL){
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.avatar_URL = avatar_URL;
        DataBase dataBase = DataBase.get_instance();
    }

    public String content_string(){
        return login+","+password+","+nickname+","+avatar_URL+"\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar_URL() {
        return avatar_URL;
    }

    public void setAvatar_URL(String avatar_URL) {
        this.avatar_URL = avatar_URL;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getBook_counter() {
        return book_counter;
    }

    public void setBook_counter(int book_counter) {
        this.book_counter = book_counter;
    }

    public int[] getBooks_id() {
        return books_id;
    }

    public void setBooks_id(int[] books_id) {
        this.books_id = books_id;
    }
}
