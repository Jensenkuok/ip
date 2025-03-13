package jamal.tasks;

/**
 * Represents a simple to-do task.
 * A <code>ToDo</code> object only contains a description.
 */
public class ToDo extends Task {

    /**
     * Constructs a ToDo task with the given description.
     *
     * @param description The description of the task.
     */
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getTaskDisplay() {
        return "[T]" + super.getTaskDisplay();
    }
}
