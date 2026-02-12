package habittracker.DAO;

import habittracker.database.Connection;
import habittracker.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public void insertUser(User user) {

        String sql = """
            INSERT INTO User
            (username, password, limitTimeSpentInSocialMediaPerDay)
            VALUES (?, ?, ?)
        """;

        try (
                java.sql.Connection conn = Connection.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getLimitTimeSpentInSocialMediaPerDay());

            stmt.executeUpdate();

            System.out.println("Hábito criado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir hábito");
            e.printStackTrace();
        }
    }
}
