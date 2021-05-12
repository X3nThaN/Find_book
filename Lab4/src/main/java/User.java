import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private double rate;
    private List<Integer> books_id;



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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<Integer> getBooks_id() {
        return books_id;
    }

    public void setBooks_id(List<Integer> books_id) {
        this.books_id = books_id;
    }
}
