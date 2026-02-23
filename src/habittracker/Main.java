package habittracker;

import habittracker.DAO.HabitDAO;
import habittracker.DAO.UserDAO;
import habittracker.model.Habit;
import habittracker.model.Menus;
import habittracker.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menus menus = new Menus();
        HabitDAO habitDAO = new HabitDAO();
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);

        User loggedUser;

        menus.showFirstMenu();
        int firstMenuOption;

        try {
            firstMenuOption = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
            return;
        }

        if (firstMenuOption == 1) {
            menus.showUsername();
            String username = scanner.nextLine().trim();

            menus.showPassword();
            String password = scanner.nextLine().trim();

            menus.showLimitPerDay();
            int limitPerDay;
            try {
                limitPerDay = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Limite inválido.");
                return;
            }

            loggedUser = new User(username, password, limitPerDay);
            userDAO.insertUser(loggedUser);

            System.out.println("Usuário criado com sucesso!");

        } else if (firstMenuOption == 2) {

            menus.showUsername();
            String username = scanner.nextLine().trim();

            menus.showPassword();
            String password = scanner.nextLine().trim();

            loggedUser = userDAO.login(username, password);

            if (loggedUser == null) {
                System.out.println("Login ou senha inválidos.");
                return;
            }
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        boolean running = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (running) {

            menus.showMenu();
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números.");
                continue;
            }

            switch (option) {

                case 1 -> {

                    System.out.println("Rede social:");
                    String socialMedia = scanner.nextLine();

                    System.out.println("Quanto tempo no(a) " + socialMedia + ":");
                    int timeSpent;
                    try {
                        timeSpent = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Tempo inválido.");
                        continue;
                    }

                    System.out.println("Dia do hábito (dd/MM/yyyy):");
                    LocalDate date;
                    try {
                        date = LocalDate.parse(scanner.nextLine(), formatter);
                    } catch (Exception e) {
                        System.out.println("Data inválida.");
                        continue;
                    }

                    int totalSoFar =
                            habitDAO.getTotalTimeSpentOnDay(loggedUser.getId(), date);

                    int newTotal = totalSoFar + timeSpent;

                    if (newTotal > loggedUser.getLimitTimeSpentInSocialMediaPerDay()) {
                        System.out.println("Você ultrapassou seu limite diário!");
                    }

                    Habit habit = new Habit(
                            socialMedia,
                            timeSpent,
                            newTotal,
                            date,
                            loggedUser.getId()
                    );

                    habitDAO.insertHabit(habit);
                    System.out.println("Hábito criado com sucesso!");
                }

                case 2 -> {

                    List<Habit> habits =
                            habitDAO.getAllHabitsByUserId(loggedUser.getId());

                    if (habits.isEmpty()) {
                        System.out.println("Nenhum hábito encontrado.");
                    } else {
                        System.out.println("=== Histórico ===");
                        for (Habit habit : habits) {
                            System.out.println(habit);
                        }
                    }
                }

                case 3 -> {
                    
                    System.out.println("Informe a data (dd/MM/yyyy):");
                    try {
                        LocalDate date =
                                LocalDate.parse(scanner.nextLine(), formatter);

                        int total =
                                habitDAO.getTotalTimeSpentOnDay(loggedUser.getId(), date);

                        System.out.println("Total do dia: " + total + " minutos");
                    } catch (Exception e) {
                        System.out.println("Data inválida.");
                    }
                }

                case 4 -> {
                    System.out.println("Saindo do Habit Tracker. Até mais!");
                    running = false;
                }

                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}