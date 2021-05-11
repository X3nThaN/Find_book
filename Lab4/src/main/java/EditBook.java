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

@WebServlet(urlPatterns = "/edit")
public class EditBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BDB bdb = BDB.get_instance();
        JsonObject data = new Gson().fromJson(req.getReader(), JsonObject.class);
        int id = data.get("id").getAsInt();
        String book_name = data.get("book_name").getAsString();
        String img_url = data.get("img_address").getAsString();
        String book_description = data.get("book_description").getAsString();
        String book_country = data.get("book_country").getAsString();
        String book_date = data.get("book_date").getAsString();

        Booky book = new Booky(id,book_name, img_url, book_description, book_country, book_date);
        try {
            bdb.editBook(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        out.print("200");
        out.close();
    }
}
