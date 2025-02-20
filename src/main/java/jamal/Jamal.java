package jamal;

import java.util.ArrayList;
import java.util.Scanner;

public class Jamal {

    public static void main(String[] args) {
        
        JamalUI.showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("bye")) {
                JamalUI.showGoodbyeMessage();
                break;
            } else if (input.equals("list")) {
                JamalUI.showSeparator();
                if (tasks.isEmpty()) {
                    System.out.println("Hey man, you got nothing yet! Start adding tasks.");
                } else {
                    System.out.println("You got a lot to do boy:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "." + tasks.get(i).getTaskDisplay());
                    }
                }
                JamalUI.showSeparator();
                //marking tasks
            } else if (input.startsWith("mark ")) {
                try {
                    int taskIndex = Integer.parseInt(input.substring(5)) - 1;
                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        tasks.get(taskIndex).markAsDone();
                        JamalUI.showSeparator();
                        System.out.println("Lesgooo i've marked this task as done:");
                        System.out.println("  " + tasks.get(taskIndex).getTaskDisplay());
                        JamalUI.showSeparator();
                    } else {
                        System.out.println("Bruh, that task number ain't valid.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Hey man, type a valid task number after 'mark'.");
                }

                //unmarking tasks
            } else if (input.startsWith("unmark ")) {
                try {
                    int taskIndex = Integer.parseInt(input.substring(7)) - 1;
                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        tasks.get(taskIndex).unmarkAsDone();
                        JamalUI.showSeparator();
                        System.out.println("Damn i thought you finished it already, guess not:");
                        System.out.println("  " + tasks.get(taskIndex).getTaskDisplay());
                        JamalUI.showSeparator();
                    } else {
                        System.out.println("Bruh, that task number ain't valid.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Hey man, type a valid task number after 'unmark'.");
                }

            } else if (input.startsWith("todo")) {
                try {
                    String taskDescription = input.substring(4).trim();
                    if (taskDescription.isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    tasks.add(new ToDo(taskDescription));
                    JamalUI.showSeparator();
                    System.out.println("Got it! One more task for you:");
                    System.out.println("  " + tasks.get(tasks.size() - 1).getTaskDisplay());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    JamalUI.showSeparator();
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
                    tasks.add(new Deadline(taskDescription, deadline));

                    JamalUI.showSeparator();
                    System.out.println("Got it! One more task for you:");
                    System.out.println("  " + tasks.get(tasks.size() - 1).getTaskDisplay());
                    System.out.println("Now you got " + tasks.size() + " tasks in the list.");
                    JamalUI.showSeparator();

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

                    tasks.add(new Event(taskDescription, from, to));

                    JamalUI.showSeparator();
                    System.out.println("Got it! One more task for you:");
                    System.out.println("  " + tasks.get(tasks.size() - 1).getTaskDisplay());
                    System.out.println("Now you got " + tasks.size() + " tasks in the list.");
                    JamalUI.showSeparator();

                } catch (Exception e) {
                    System.out.println("Hey man, use the format: event <task> /from <start> /to <end>");
                }

            } else {
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
