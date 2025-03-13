package jamal.logic;

import jamal.command.*;

/**
 * Parses user input and returns the corresponding command.
 */
public class Parser {

    /**
     * Parses the given input string and returns the corresponding command.
     *
     * @param input The user input.
     * @return A Command object representing the parsed command.
     */
    public static Command parseCommand(String input) {
        input = input.trim();

        try {
            if (input.equals("bye")) {
                return new ExitCommand();
            } else if (input.equals("list")) {
                return new ListCommand();
            } else if (input.startsWith("mark")) {
                return parseIndexCommand(input, "mark", MarkCommand.class);
            } else if (input.startsWith("unmark")) {
                return parseIndexCommand(input, "unmark", UnmarkCommand.class);
            } else if (input.startsWith("delete")) {
                return parseIndexCommand(input, "delete", DeleteCommand.class);
            } else if (input.startsWith("todo")) {
                return parseTodoCommand(input);
            } else if (input.startsWith("deadline")) {
                return parseDeadlineCommand(input);
            } else if (input.startsWith("event")) {
                return parseEventCommand(input);
            } else if (input.startsWith("find")) {
                return parseFindCommand(input);
            } else {
                throw new IllegalArgumentException("My bad, i don't know what that means");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        }

        return null;
    }

    /**
     * Parses index-based commands such as mark, unmark, and delete.
     *
     * @param input The user input string.
     * @param commandType The type of command (e.g., "mark", "delete").
     * @param commandClass The command class associated with this command type.
     * @return A Command object representing the parsed index command.
     * @throws IllegalArgumentException If the index is missing or invalid.
     */
    private static Command parseIndexCommand(String input, String commandType, Class<? extends Command> commandClass) {
        try {
            String numberPart = input.substring(commandType.length()).trim();
            if (numberPart.isEmpty()) throw new IllegalArgumentException("Hey man, type a valid task number after '" + commandType + "'.");

            int index = Integer.parseInt(numberPart) - 1;
            if (commandClass == MarkCommand.class) return new MarkCommand(index);
            if (commandClass == UnmarkCommand.class) return new UnmarkCommand(index);
            if (commandClass == DeleteCommand.class) return new DeleteCommand(index);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Hey man, type a valid task number after '" + commandType + "'.");
        }
        return null;
    }

    /**
     * Parses and returns a Todo command.
     *
     * @param input The user input string.
     * @return A new AddCommand object for a Todo task.
     * @throws IllegalArgumentException If the description is empty.
     */
    private static Command parseTodoCommand(String input) {
        String description = input.substring(4).trim();
        if (description.isEmpty()) throw new IllegalArgumentException("Hey, use the format: todo <task>");
        return new AddCommand("todo", description, null, null);
    }

    /**
     * Parses and returns a Deadline command.
     *
     * @param input The user input string.
     * @return A new AddCommand object for a Deadline task.
     * @throws IllegalArgumentException If the format is incorrect.
     */
    private static Command parseDeadlineCommand(String input) {
        int byIndex = input.indexOf("/by");
        if (byIndex == -1) throw new IllegalArgumentException("Hey, use the format: deadline <task> /by <time>");

        String description = input.substring(9, byIndex).trim();
        String deadline = input.substring(byIndex + 4).trim();

        if (description.isEmpty() || deadline.isEmpty()) throw new IllegalArgumentException("Hey, use the format: deadline <task> /by <time>");
        return new AddCommand("deadline", description, deadline, null);
    }

    /**
     * Parses and returns an Event command.
     * Extracts the description, start time, and end time from user input.
     *
     * @param input The user input string.
     * @return A new AddCommand object for an Event task.
     * @throws IllegalArgumentException If the format is incorrect or required fields are missing.
     */
    private static Command parseEventCommand(String input) {
        int fromIndex = input.indexOf("/from");
        int toIndex = input.indexOf("/to");
        if (fromIndex == -1 || toIndex == -1 || fromIndex > toIndex)
            throw new IllegalArgumentException("Hey, use the format: event <task> /from <start> /to <end>");

        String description = input.substring(6, fromIndex).trim();
        String from = input.substring(fromIndex + 6, toIndex).trim();
        String to = input.substring(toIndex + 4).trim();

        if (description.isEmpty() || from.isEmpty() || to.isEmpty())
            throw new IllegalArgumentException("Hey, use the format: event <task> /from <start> /to <end>");

        return new AddCommand("event", description, from, to);
    }

    /**
     * Parses and returns a Find command.
     * Extracts the keyword from the user input and searches for matching tasks.
     *
     * @param input The user input string.
     * @return A new FindCommand object with the extracted keyword.
     * @throws IllegalArgumentException If the keyword is missing.
     */
    private static Command parseFindCommand(String input) {
        try {
            if (input.length() <= 5) { // Prevents substring(5) from failing
                throw new IllegalArgumentException("Hey, you need to enter a keyword to search.");
            }
            String keyword = input.substring(5).trim();
            if (keyword.isEmpty()) {
                throw new IllegalArgumentException("Hey, you need to enter a keyword to search.");
            }
            return new FindCommand(keyword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
