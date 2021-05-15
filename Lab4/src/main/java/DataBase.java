import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    //NEED UPDATE AND CREATE DATABASE
    private static final String EDIT_BOOK_SQL = "update books set book_name = ?, book_author = ?, img_url = ?, book_publishing = ?," +
            "book_genre = ?, book_description = ?, book_country = ?, book_date = ? where id = ?;"; //updated
    private static final String DELETE_BOOK_SQL = "delete from books where id = ?;"; //dont need update
    private static final String ADD_BOOK_SQL = "insert into books (book_name, book_author, img_url, book_publishing, " +
            "book_genre, book_description, book_country, book_date)" +  //updated
            "values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_BOOKS = "select * from books"; //dont need update
    private static final String EDIT_USER_SQL = "update books set book_name = ?,img_url = ?, book_description = ?," + //need update
            " book_country = ?, book_date = ? where id = ?;";
    private static final String DELETE_USER_SQL = "delete from books where id = ?;"; //need update
    private static final String ADD_USER_SQL = "insert into books (book_name, img_url, book_description, book_country, book_date)" + //need update
            "values (?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BOOKS = "select * from books"; //need update
    private static final String URL = "jdbc:mysql://localhost:3306/book_data_base"; //need update
    private static final String USERNAME = "Admin-of-project"; //need update
    private static final String PASSWORD = "find-book-forever"; //need update
    private static DataBase instance;
    private Connection connection;

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public DataBase(){
    }

    public List < Booky > getAllBooks(){
        List<Booky> books = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String book_name = resultSet.getString("book_name");
                String book_author = resultSet.getString("book_author");
                String img_url = resultSet.getString("img_url");
                String book_publishing = resultSet.getString("book_publishing");
                String book_genre = resultSet.getString("book_genre");
                String book_description = resultSet.getString("book_description");
                String book_country = resultSet.getString("book_country");
                int book_date = resultSet.getInt("book_date");

                books.add(new Booky(id, book_name, book_author, img_url, book_publishing, book_genre, book_description, book_country, book_date));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;

    }

    public void addBook(Booky book) throws SQLException{
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOOK_SQL);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getImg_URL());
        preparedStatement.setString(4, book.getPublishing());
        preparedStatement.setString(5, book.getGenre());
        preparedStatement.setString(6, book.getDescription());
        preparedStatement.setString(7, book.getCountry());
        preparedStatement.setInt(8, book.getYear());

        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("select max(id) from books");
        book.setId(preparedStatement.executeUpdate());
    }
    public static DataBase get_instance(){
        if(instance == null)
            instance = new DataBase();
        return instance;
    }

    public boolean deleteBook(int id) throws SQLException {
        boolean is_deleted;
        Connection connection = getConnection();
        PreparedStatement statement =connection.prepareStatement(DELETE_BOOK_SQL);
        statement.setInt(1, id);
        is_deleted = statement.executeUpdate() > 0;
        return is_deleted;
    }

    public boolean editBook(Booky booky) throws SQLException{
        boolean is_edited;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(EDIT_BOOK_SQL);
        preparedStatement.setString(1, booky.getName());
        preparedStatement.setString(2, booky.getAuthor());
        preparedStatement.setString(3, booky.getImg_URL());
        preparedStatement.setString(4, booky.getPublishing());
        preparedStatement.setString(5, booky.getGenre());
        preparedStatement.setString(6, booky.getDescription());
        preparedStatement.setString(7, booky.getCountry());
        preparedStatement.setInt(8, booky.getYear());
        preparedStatement.setInt(9, booky.getId());
        is_edited = preparedStatement.executeUpdate()>0;
        return is_edited;
    }
}
