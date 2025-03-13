package jamal.logic;

import jamal.command.*;

public class Parser {
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

    private static Command parseTodoCommand(String input) {
        String description = input.substring(4).trim();
        if (description.isEmpty()) throw new IllegalArgumentException("Hey, use the format: todo <task>");
        return new AddCommand("todo", description, null, null);
    }

    private static Command parseDeadlineCommand(String input) {
        int byIndex = input.indexOf("/by");
        if (byIndex == -1) throw new IllegalArgumentException("Hey, use the format: deadline <task> /by <time>");

        String description = input.substring(9, byIndex).trim();
        String deadline = input.substring(byIndex + 4).trim();

        if (description.isEmpty() || deadline.isEmpty()) throw new IllegalArgumentException("Hey, use the format: deadline <task> /by <time>");
        return new AddCommand("deadline", description, deadline, null);
    }

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
}