package habittracker;

import habittracker.DAO.HabitDAO;
import habittracker.DAO.UserDAO;
import habittracker.model.Habit;
import habittracker.model.Menus;
import habittracker.model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menus menus = new Menus();
        HabitDAO habitDAO = new HabitDAO();
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);

        menus.showFirstMenu();
        int firstMenuOption = scanner.nextInt();

        if (firstMenuOption == 1) {
            menus.showUsername();
            String username = scanner.next();
            scanner.nextLine();
            menus.showPassword();
            String password = scanner.next();
            scanner.nextLine();
            System.out.println("Definir limite de tempo diario:");
            int limitTimeSpentInSocialMediaPerDay = scanner.nextInt();

            User user = new User(username, password, limitTimeSpentInSocialMediaPerDay);
        }  else if (firstMenuOption == 2) {

        }
        menus.showMenu();
        int secondMenuOption = scanner.nextInt();
        if (secondMenuOption == 1) {
            System.out.println("Rede social:");
            String socialMedia = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Quanto tempo no(a)" + socialMedia);
            int timeSpentInSocialMedia = scanner.nextInt();

            //Habit habit = new Habit(socialMedia, timeSpentInSocialMedia, );
            //habitDAO.insertHabit(habit);
        }

    }
}