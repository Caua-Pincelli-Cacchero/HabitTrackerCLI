package habittracker.DAO;
import habittracker.model.Habit;
import habittracker.database.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HabitDAO {

    public void insertHabit(Habit habit) {

        String sql = """
            INSERT INTO Habit
            (socialMedia, dayTimeSpentInSocialMedia, totalTimeSpent, user_id)
            VALUES (?, ?, ?, ?)
        """;

        try (
                java.sql.Connection conn = Connection.getConnexion();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, habit.getSocialMedia());
            stmt.setInt(2, habit.getDayTimeSpentInSocialMedia());
            stmt.setInt(3, habit.getTotalTimeSpentInSocialMedia());

            stmt.executeUpdate();

            System.out.println("Hábito criado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir hábito");
            e.printStackTrace();
        }
    }
}
