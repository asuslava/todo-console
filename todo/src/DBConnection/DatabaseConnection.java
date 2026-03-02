package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String url = "jdbc:sqlite:todo/data/todo.db";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url);
    }

    public static void createTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS tasks (
                number INTEGER PRIMARY KEY AUTOINCREMENT,
                id TEXT UNIQUE,
                name TEXT NOT NULL,
                status TEXT NOT NULL,
                date TEXT NOT NULL
                );
                """;
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table is ready\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
