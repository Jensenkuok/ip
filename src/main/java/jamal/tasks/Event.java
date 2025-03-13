package jamal.tasks;

public class Event extends Task {
    private final String from; // Start time
    private final String to;   // End time

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String getFrom() { return from; }

    public String getTo() { return to; }

    @Override
    public String getTaskDisplay() {
        return "[E]" + super.getTaskDisplay() + " (from: " + from + " to: " + to + ")";
    }
}