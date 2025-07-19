import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) {

        //TO DO LIST MANAGER


        System.out.println("Hello user! Welcome to 'To Do List Manager'!");
        System.out.println("Can I get your name?: ");

        String name = scanner.nextLine();

        if (name.equalsIgnoreCase("q")) {
            System.out.println("Thanks for playing");
        }

        while(true) {
            System.out.println("*********************************************************************");
            System.out.println("Choose 1) Creating a task or 2) Looking for created one (q to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing " + name);
                break;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Choose either 1 or 2");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("What's the name of the task? ");
                    String task = scanner.nextLine();

                    System.out.println("Is the task, " + task + ", complete or incomplete? ");
                    String input2 = scanner.nextLine();

                    if (input2.equalsIgnoreCase("q")) {
                        System.out.println("Thanks for playing " + name);
                        break;
                    }

                    boolean complete;
                    try {
                        complete = Boolean.parseBoolean(input2);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid! Choose either yes or no");
                        continue;
                    }

                    System.out.println("Task: " + task + ". Completed:" + complete);
                }

                case 2 -> System.out.println("What task are you looking for? ");
                default -> System.out.println("Invalid. Choose either 1 or 2");
            }

        }

        scanner.close();
    }
}