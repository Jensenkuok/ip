package jamal.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private final LocalDateTime by;
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");

    public Deadline(String description, String by) {
        super(description);
        this.by = parseDateTime(by);
    }

    private LocalDateTime parseDateTime(String by) {
        try {
            // Primary expected input format (e.g., 2/12/2019 1800)
            return LocalDateTime.parse(by, INPUT_FORMATTER);
        } catch (DateTimeParseException e1) {
            try {
                // Try parsing the output format (e.g., May 11 2002, 8:00PM)
                return LocalDateTime.parse(by, OUTPUT_FORMATTER);
            } catch (DateTimeParseException e2) {
                throw new IllegalArgumentException("Invalid date format! Use dd/MM/yyyy HHmm (e.g., 2/12/2019 1800).");
            }
        }
    }


    public String getBy() {
        return by.format(OUTPUT_FORMATTER);
    }

    @Override
    public String getTaskDisplay() {
        return "[D]" + super.getTaskDisplay() + " (by: " + getBy() + ")";
    }
}
