package jamal.tasks;

/**
 * Represents an event task with a start and end time.
 * A <code>Event</code> object contains a description, start time, and end time.
 */
public class Event extends Task {
    private final String from; // Start time
    private final String to;   // End time

    /**
     * Constructs an Event task with the given description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Retrieves the start time of the event.
     *
     * @return The start time as a string.
     */
    public String getFrom() { return from; }

    /**
     * Retrieves the end time of the event.
     *
     * @return The end time as a string.
     */
    public String getTo() { return to; }

    @Override
    public String getTaskDisplay() {
        return "[E]" + super.getTaskDisplay() + " (from: " + from + " to: " + to + ")";
    }
}
