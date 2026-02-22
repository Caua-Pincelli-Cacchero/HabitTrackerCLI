package habittracker.DAO;

import habittracker.database.Connection;
import habittracker.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    public void insertUser(User user) {

        String sql = """
        INSERT INTO User (username, password, limitTimeSpentInSocialMediaPerDay)
        VALUES (?, ?, ?)
    """;

        try (
                java.sql.Connection conn = Connection.getConnexion();
                PreparedStatement stmt = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getLimitTimeSpentInSocialMediaPerDay());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }

            System.out.println("Usuário criado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar usuário");
            e.printStackTrace();
        }
    }

    public User login(String username, String password) {

        String sql = """
                SELECT id, username, password, limitTimeSpentInSocialMediaPerDay
                FROM User
                WHERE username = ? AND password = ?""";

        try (
                java.sql.Connection conn = Connection.getConnexion();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("limitTimeSpentInSocialMediaPerDay")
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
