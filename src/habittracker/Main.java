package habittracker;

import habittracker.model.Menus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menus principalMenu = new Menus();
        Menus menus = new Menus();
        Scanner scanner = new Scanner(System.in);

        menus.showFirstMenu();
        int firstMenuOption = scanner.nextInt();

        if (firstMenuOption == 1) {
            menus.showUsername();

            menus.showPassword();
        }  else if (firstMenuOption == 2) {

        }



        principalMenu.showMenu();

    }
}