package habittracker.model;

public class Menus {
    public void showMenu() {
        System.out.println("------------------------------");
        System.out.println("Bem vindo ao Habit Tracker");
        System.out.println("------------------------------");
        System.out.println("Selecione uma opção:");
        System.out.println("");
        System.out.println("1 - Registrar tempo em rede social");
        System.out.println("2 - Ver histórico");
        System.out.println("3 - Total do dia");
        System.out.println("4 - Definir limite");
        System.out.println("5 - Sair");
        System.out.println("------------------------------");
    }

    public void showFirstMenu() {
        System.out.println("------------------------------");
        System.out.println("1 - Registrar Usuário");
        System.out.println("2 - Log In");
        System.out.println("------------------------------");
    }

    public void showUsername() {
        System.out.println("------------------------------");
        System.out.println("Username:");
    }

    public void showPassword() {
        System.out.println("Senha:");
        System.out.println("------------------------------");
    }


}
