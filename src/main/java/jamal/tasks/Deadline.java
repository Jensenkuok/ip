package jamal.tasks;

/**
 * Represents a deadline task with a specific due date.
 * A <code>Deadline</code> object contains a description and a due date.
 */
public class Deadline extends Task {
    private final String by; // Stores deadline details

    /**
     * Constructs a Deadline task with the given description and due date.
     *
     * @param description The description of the task.
     * @param by The due date of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Retrieves the due date of the deadline task.
     *
     * @return The due date as a string.
     */
    public String getBy() { return by; }

    @Override
    public String getTaskDisplay() {
        return "[D]" + super.getTaskDisplay() + " (by: " + by + ")";
    }
}
