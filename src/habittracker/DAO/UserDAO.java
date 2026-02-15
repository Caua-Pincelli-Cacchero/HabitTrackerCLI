package habittracker.DAO;

import habittracker.database.Connection;
import habittracker.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void insertUser(User user) {

        String sql = """
            INSERT INTO User
            (username, password, limitTimeSpentInSocialMediaPerDay)
            VALUES (?, ?, ?)
        """;

        try (
                java.sql.Connection conn = Connection.getConnexion();
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

    public User login(String username, String password) {

        String sql = """
            SELECT * FROM User WHERE username = ? AND password = ?;
        """;

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
                        rs.getInt("limitPerDay")
                );
            }
        } catch (SQLException e) {
            System.out.println("Usuário ou senha incorreto!");
            e.printStackTrace();
        }

        return null;
    }
}
