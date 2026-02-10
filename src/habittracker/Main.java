package habittracker;

import habittracker.DAO.HabitDAO;
import habittracker.model.Habit;
import habittracker.model.Menus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menus menus = new Menus();
        HabitDAO habitDAO = new HabitDAO();
        Scanner scanner = new Scanner(System.in);

        menus.showFirstMenu();
        int firstMenuOption = scanner.nextInt();

        if (firstMenuOption == 1) {
            menus.showUsername();

            menus.showPassword();
        }  else if (firstMenuOption == 2) {

        }
        menus.showMenu();
        int secondMenuOption = scanner.nextInt();
        if (secondMenuOption == 1) {
            System.out.println("Rede social:");
            String socialMedia = scanner.nextLine();

            System.out.println("Quanto tempo no(a)" + socialMedia);
            int timeSpentInSocialMedia = scanner.nextInt();

            Habit habit = new Habit(socialMedia, timeSpentInSocialMedia);
            habitDAO.insertHabit(habit);
        }

    }
}