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
import java.util.ArrayList;
import java.util.List;

@WebServlet( urlPatterns="/createBook")
public class CreateBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Booky> responseJSON = new ArrayList<>();
        DataBase dataBase = DataBase.get_instance();
        responseJSON = dataBase.getAllBooks();

        String json = new Gson().toJson(responseJSON);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        JsonObject data = new Gson().fromJson(req.getReader(), JsonObject.class);
        String book_name = data.get("book_name").getAsString();
        String book_author = data.get("book_author").getAsString();
        String img_url = data.get("img_address").getAsString();
        String book_publishing = data.get("book_publishing").getAsString();
        String book_genre = data.get("book_genre").getAsString();
        String book_description = data.get("book_description").getAsString();
        String book_country = data.get("book_country").getAsString();
        int book_date = data.get("book_date").getAsInt();
        DataBase dataBase = DataBase.get_instance();

        Booky book = new Booky(book_name, book_author, img_url, book_publishing, book_genre, book_description, book_country, book_date);
        try{
            dataBase.addBook(book);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        PrintWriter out = resp.getWriter();
        out.print("200");
        out.close();
    }
}

