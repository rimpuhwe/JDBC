import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static final String URL = "jdbc:postgresql://localhost:5432/studentmanagement";
    private static final String USER  ="postgres";
    private static final String PASSWORD = "raissamich12@gmail.com";

    Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
