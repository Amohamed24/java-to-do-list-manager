import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    private final ArrayList<Task> tasks = new ArrayList<>();

    public TaskManager () {
        tasks.add(new Task("Shower", false, LocalDate.of(2025,11,11)));
        tasks.add(new Task("Make bed", true, LocalDate.of(2025,11,21)));
        tasks.add(new Task("Wash dishes", false, LocalDate.of(2025,12,01)));
        tasks.add(new Task("Go for a run", true, LocalDate.of(2025,11,11)));
        tasks.add(new Task("Meal prep", false, LocalDate.of(2025,11,15)));
    }

    void viewTasks() {
        if(tasks.isEmpty()){
            System.out.println("You have no tasks.");
        }
        else {
            System.out.println("\nHere are all the tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    void addTask(Scanner scanner) {
        System.out.println("What task would you like to add?: ");
        String name = scanner.nextLine();

        System.out.println("Is this task completed? (true/false): ");
        boolean completed;
        try {
            completed = Boolean.parseBoolean(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid! Defaulting to not completed");
            completed = false;
        }

        System.out.println("Enter due date (YYYY-MM-DD): ");
        LocalDate date;
        try {
            date = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Defaulting to today");
            date = LocalDate.now();
        }


        tasks.add(new Task(name, completed, date));
        System.out.println("Task  /" + name + "/ was added.");
    }

    void removeTask(Scanner scanner) {
        viewTasks();

        System.out.println("\nWhat task would you like to remove?: ");
        String remove = scanner.nextLine();

        boolean found = false;
        for (Task task : tasks) {
            if(task.getName().equalsIgnoreCase(remove)) {
                tasks.remove(task);
                System.out.println("Task " + remove + " removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No task found with name: " + remove);
        }

        System.out.println("You removed " + remove + " from tasks list");
    }
}
