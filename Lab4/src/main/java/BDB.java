import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BDB {
    private static final String EDIT_BOOK_SQL = "update books set book_name = ?,img_url = ?, book_description = ?," +
            " book_country = ?, book_date = ? where id = ?;";
    private static final String DELETE_BOOK_SQL = "delete from books where id = ?;";
    private static final String ADD_BOOK_SQL = "insert into books (book_name, img_url, book_description, book_country, book_date)" +
            "values (?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_BOOKS = "select * from books";
    private static final String URL = "jdbc:mysql://localhost:3306/book_data_base";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static BDB instance;
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

    public BDB(){
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
                String img_url = resultSet.getString("img_url");
                String book_description = resultSet.getString("book_description");
                String book_country = resultSet.getString("book_country");
                String book_date = resultSet.getString("book_date");

                books.add(new Booky(id, book_name, img_url, book_description, book_country, book_date));
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
        preparedStatement.setString(2, book.getImg());
        preparedStatement.setString(3, book.getDescription());
        preparedStatement.setString(4, book.getCountry());
        preparedStatement.setString(5, book.getYear());

        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("select max(id) from books");
        book.setId(preparedStatement.executeUpdate());
    }
    public static BDB get_instance(){
        if(instance == null)
            instance = new BDB();
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
        preparedStatement.setString(2, booky.getImg());
        preparedStatement.setString(3, booky.getDescription());
        preparedStatement.setString(4, booky.getCountry());
        preparedStatement.setString(5, booky.getYear());
        preparedStatement.setInt(6, booky.getId());
        is_edited = preparedStatement.executeUpdate()>0;
        return is_edited;
    }
}
