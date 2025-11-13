import java.time.LocalDate;

public class Task {

    private final String name;
    private final boolean completion;
    private final LocalDate date;

    public Task(String name, boolean completion, LocalDate date) {
        this.name = name;
        this.completion = completion;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Task: " + name + "| Date: " + date +  "| Completion: " + completion;
    }
}
