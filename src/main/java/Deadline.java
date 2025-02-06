public class Deadline extends Task {
    protected String by; // Stores deadline details

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getTaskDisplay() {
        return "[D]" + super.getTaskDisplay() + " (by: " + by + ")";
    }
}