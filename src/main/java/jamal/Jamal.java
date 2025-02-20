package jamal;

import java.util.Scanner;

public class Jamal {

    public static void main(String[] args) {
        
        JamalUI.showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("bye")) {
                JamalUI.showGoodbyeMessage();
                break;
            } else if (input.equals("list")) {
                taskManager.listTasks();
                //marking tasks
            } else if (input.startsWith("mark ")) {
                try {
                    int taskIndex = Integer.parseInt(input.substring(5)) - 1;
                    taskManager.markTask(taskIndex);
                } catch (NumberFormatException e) {
                    System.out.println("Hey man, type a valid task number after 'mark'.");
                }

                //unmarking tasks
            } else if (input.startsWith("unmark r")) {
                try {
                    int taskIndex = Integer.parseInt(input.substring(7)) - 1;
                    taskManager.unmarkTask(taskIndex);
                } catch (NumberFormatException e) {
                    System.out.println("Hey man, type a valid task number after 'unmark'.");
                }

            } else if (input.startsWith("todo")) {
                try {
                    String taskDescription = input.substring(4).trim();
                    if (taskDescription.isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    taskManager.addTodoTask(taskDescription);
                } catch (IllegalArgumentException e) {
                    JamalUI.showSeparator();
                    System.out.println("Hey man, todo task cannot be empty.");
                    System.out.println("Use the format: todo <task>");
                    JamalUI.showSeparator();
                }

            } else if (input.startsWith("deadline")) {
                try {
                    int byIndex = input.indexOf("/by");

                    if (byIndex == -1) { // if "/by" is missing, throw error
                        throw new Exception();
                    }

                    String taskDescription = input.substring(8, byIndex).trim();
                    String deadline = input.substring(byIndex + 4).trim();
                    taskManager.addDeadlineTask(taskDescription, deadline);

                } catch (Exception e) {
                    System.out.println("Hey man, use the format: deadline <task> /by <time>");
                }
            } else if (input.startsWith("event")) {
                try {
                    int fromIndex = input.indexOf("/from");
                    int toIndex = input.indexOf("/to");

                    if (fromIndex == -1 || toIndex == -1 || fromIndex > toIndex) {
                        throw new Exception();
                    }

                    String taskDescription = input.substring(5, fromIndex).trim();
                    String from = input.substring(fromIndex + 6, toIndex).trim();
                    String to = input.substring(toIndex + 4).trim();

                    taskManager.addEventTask(taskDescription, from, to);

                } catch (Exception e) {
                    System.out.println("Hey man, use the format: event <task> /from <start> /to <end>");
                }

            } else if(input.startsWith("delete ")) {
                try {
                    int taskIndex = Integer.parseInt(input.substring(7)) - 1;
                    taskManager.deleteTask(taskIndex);
                } catch (NumberFormatException e) {
                    System.out.println("Hey man, type a valid task number after 'delete'.");
                }
            }
            else {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    JamalUI.showSeparator();
                    System.out.println("My bad bro, ion know what that means");
                    JamalUI.showSeparator();
                }
            }
        }

        scanner.close();
    }
}
