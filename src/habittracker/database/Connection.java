package habittracker.database;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/HabitTrackerCLI?useSSL=false&serverTimezone=UTC";

    public static java.sql.Connection getConexao() {
        try {
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            java.sql.Connection conn = DriverManager.getConnection(URL, user, password);
            System.out.println("Conectado com sucesso!");
            return conn;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar");
            e.printStackTrace();
            return null;
        }
    }
}

