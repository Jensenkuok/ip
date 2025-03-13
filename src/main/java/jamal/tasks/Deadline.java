package jamal.tasks;

public class Deadline extends Task {
    private final String by; // Stores deadline details

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() { return by; }

    @Override
    public String getTaskDisplay() {
        return "[D]" + super.getTaskDisplay() + " (by: " + by + ")";
    }
}
