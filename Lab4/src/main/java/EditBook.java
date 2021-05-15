import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/editBook")
public class EditBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        DataBase dataBase = DataBase.get_instance();
        JsonObject data = new Gson().fromJson(req.getReader(), JsonObject.class);
        int id = data.get("id").getAsInt();
        String book_name = data.get("book_name").getAsString();
        String book_author = data.get("book_author").getAsString();
        String img_url = data.get("img_address").getAsString();
        String book_publishing = data.get("book_publishing").getAsString();
        String book_genre = data.get("book_publishing").getAsString();
        String book_description = data.get("book_description").getAsString();
        String book_country = data.get("book_country").getAsString();
        int book_date = data.get("book_date").getAsInt();

        Booky book = new Booky(id,book_name, book_author, img_url, book_publishing, book_genre, book_description, book_country, book_date);
        try {
            dataBase.editBook(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        out.print("200");
        out.close();
    }
}
