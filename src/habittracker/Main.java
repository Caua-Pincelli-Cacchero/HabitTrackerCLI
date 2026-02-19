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

        User loggedUser = null;

        menus.showFirstMenu();
        int firstMenuOption = scanner.nextInt();
        if (firstMenuOption == 1) {

            // Input e cadastro de novo usuário
            menus.showUsername();
            String username = scanner.next();
            scanner.nextLine();
            menus.showPassword();
            String password = scanner.next();
            scanner.nextLine();
            menus.showLimitPerDay();
            int limitTimeSpentInSocialMediaPerDay =  Integer.parseInt(scanner.nextLine().trim());
            System.out.println("------------------------------");

            User newUser = new User(username,
                password,
                limitTimeSpentInSocialMediaPerDay);

            loggedUser = newUser;
            userDAO.insertUser(newUser);
    } else if (firstMenuOption == 2) {

        // Logar usuário
        menus.showUsername();
        String username = scanner.next().trim();
        scanner.nextLine();
        menus.showPassword();
        String password = scanner.next().trim();
        System.out.println("------------------------------");

        loggedUser = userDAO.login(username, password);

        if (loggedUser == null) {
            System.out.println("Login ou Senha invalido");
            return;
        }
    } else {
            System.out.println("Opção invalida");
            return;
        }

    menus.showMenu();
    int secondMenuOption = scanner.nextInt();

    while (true) {
        if (secondMenuOption == 1) {
            System.out.println("Rede social:");
            String socialMedia = scanner.next();
            scanner.nextLine();

            System.out.printf("Quanto tempo no(a) " + socialMedia + ":");
            int timeSpentInSocialMediaOnDay = scanner.nextInt();
            scanner.nextLine();

            if (timeSpentInSocialMediaOnDay > loggedUser.getLimitTimeSpentInSocialMediaPerDay()) {
                System.out.println("Você ultrapassou seu limite diário de tempo nas redes sociais.");
            }

            int totalTimeSpentInSocialMedia = 0;
            totalTimeSpentInSocialMedia += timeSpentInSocialMediaOnDay;

            Habit habit = new Habit(socialMedia, timeSpentInSocialMediaOnDay,
                    totalTimeSpentInSocialMedia,
                    loggedUser.getLimitTimeSpentInSocialMediaPerDay());

            habitDAO.insertHabit(habit);

            System.out.println("Pressione 1 para registrar outro hábito e 2 para sair!");
            int option = scanner.nextInt();
            if (option == 1) {
                continue;
            } else if (option == 2) {
                System.out.println("Saindo do Habit Tracker, obrigado pela preferência.");
                break;
            }
        } else if (secondMenuOption == 4) {
            System.out.println("Saindo do Habit Tracker, obrigado pela preferência.");
            break;
        }
    }

    }
}