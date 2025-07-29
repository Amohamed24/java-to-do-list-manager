import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) {

        //TO DO LIST MANAGER

        AppController controller = new AppController();
        controller.start();
        scanner.close();
    }

    static class AppController {

        // create array here
        private final List<Tasks> task = new ArrayList<>();
        private final TaskManager manager = new TaskManager();

        void start() {
            System.out.println("Hello user! Welcome to 'To Do List Manager'!");
            System.out.println("Can I get your name?: ");

            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing");
            }

            while (true) {
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

                if (choice == 1) {
                    Expense expense = tracker.createAnExpense();
                    if (manager != null) {
                        task.add(expense);
                    }
                } else if (action == 2) {
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses to view yet.");
                    }

                    Expense viewed = tracker.viewAnExpense(expenses);
                    if (viewed != null) {
                        System.out.printf("Found: %s (%s): $%.2f\n", viewed.getName(), viewed.getCategory(), viewed.getAmount());
                    }
                } else {
                    System.out.println("Invalid option.");
                }
            }
        }
    }

    static class Tasks{
        private final String task;
        private final boolean completed;

        public Tasks(String task, boolean completed) {
            this.task = task;
            this.completed = completed;
        }

        public String getTask() {
            return task;
        }

        public boolean getCompleted() {
            return completed;
        }

    }

    static class TaskManager{

        public void createATask() {
            System.out.println("What's the name of the task? ");
            String taskName = scanner.nextLine();

            System.out.println("Is the task, " + taskName + ", complete or incomplete (true or false)? ");
            String completion = scanner.nextLine();

            System.out.println("Task: " + taskName + ". Completed: " + completion);
        }

        public Tasks viewATask(List<Tasks> task) {
            System.out.println("What task are you viewing? ");
            String viewTaskName = scanner.nextLine();

            for (Tasks t : task) {
                if (t.getTask().equalsIgnoreCase(viewTaskName)) {
                    return t;
                }
            }

            System.out.println("Task is not found");
            return null;
        }

    }

}