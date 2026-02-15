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
            menus.showLimitPerDay();
            int limitTimeSpentInSocialMediaPerDay = scanner.nextInt();
            System.out.println("------------------------------");

            User user = new User(username,
                    password,
                    limitTimeSpentInSocialMediaPerDay);
            userDAO.insertUser(user);
        }  else if (firstMenuOption == 2) {

            menus.showUsername();
            String username = scanner.next();
            scanner.nextLine();
            menus.showPassword();
            String password = scanner.next();
            System.out.println("------------------------------");

            userDAO.login(username, password);
        }
        menus.showMenu();
        int secondMenuOption = scanner.nextInt();

        if (secondMenuOption == 1) {
            System.out.println("Rede social:");
            String socialMedia = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Quanto tempo no(a)" + socialMedia);
            int timeSpentInSocialMedia = scanner.nextInt();

            Habit habit = new Habit(socialMedia, timeSpentInSocialMedia);
            habitDAO.insertHabit(habit);
        }

    }
}