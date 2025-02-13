package jamal;

public class Event extends Task {
    protected String from; // Start time
    protected String to;   // End time

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTaskDisplay() {
        return "[E]" + super.getTaskDisplay() + " (from: " + from + " to: " + to + ")";
    }
}