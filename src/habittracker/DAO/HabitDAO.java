package habittracker.DAO;
import habittracker.model.Habit;
import habittracker.database.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class HabitDAO {

    public void insertHabit(Habit habit) {

        String sql = """
            INSERT INTO Habit
            (socialMedia, dayTimeSpentInEspecificSocialMedia, totalTimeSpent, dateOfHabit, user_Id)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (
                java.sql.Connection conn = Connection.getConnexion();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, habit.getSocialMedia());
            stmt.setInt(2, habit.getDayTimeSpentInSocialMedia());
            stmt.setInt(3, habit.getTotalTimeSpentInEspecificSocialMedia());
            stmt.setDate(4, Date.valueOf(habit.getDayOfHabit()));
            stmt.setInt(5, habit.getUserId());

            stmt.executeUpdate();

            System.out.println("Hábito criado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar hábito");
            e.printStackTrace();
        }
    }

    public int getTotalTimeSpentOnDay(int userId, LocalDate date) {

        String sql = """
        SELECT COALESCE(SUM(dayTimeSpentInEspecificSocialMedia), 0) AS total
        FROM Habit
        WHERE user_id = ? AND dateOfHabit = ?
    """;

        try (
                java.sql.Connection conn = Connection.getConnexion();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, userId);
            stmt.setDate(2, Date.valueOf(date));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
