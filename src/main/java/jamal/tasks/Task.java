package jamal.tasks;

/**
 * Represents a general task with a description and completion status.
 * This is the base class for all task types.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task with the given description.
     * The task is initially marked as not done.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Retrieves the status icon of the task.
     * An "X" represents a completed task, and a space represents an incomplete task.
     *
     * @return The status icon.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Checks if the task is completed.
     *
     * @return true if the task is marked as done, otherwise false.
     */
    public boolean isDone() { return isDone; }

    /**
     * Retrieves the task description.
     *
     * @return The task description.
     */
    public String getDescription() { return description; }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Unmarks the task, setting it as not done.
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Retrieves a formatted string representation of the task.
     *
     * @return The formatted task display.
     */
    public String getTaskDisplay() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
