import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) {

        System.out.println("Hello! Welcome to To-Do-List Manager!");
        System.out.println("What is your name?: ");
        String name = scanner.nextLine();

        System.out.println("\nHi " + name + "!");

        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\n********************************");
            System.out.println("Please select one of the options: ");
            System.out.println("1) View all tasks");
            System.out.println("2) Add a task");
            System.out.println("3) Remove a task");
            System.out.println("(type 'q' to quit)");

            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing " + name + "!");
                break;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please enter 1, 2, or 3");
                continue;
            }

            switch (choice) {
                case 1 -> taskManager.viewTasks();
                case 2 -> taskManager.addTask(scanner);
                case 3 -> taskManager.removeTask(scanner);
                default -> System.out.println("Invalid! Please enter 1, 2, or 3");

            }
        }
        scanner.close();
    }
}

