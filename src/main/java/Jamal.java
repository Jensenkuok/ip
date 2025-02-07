import java.util.Scanner;

public class Jamal {
    static final int MAX_TASKS = 100;

    public static void main(String[] args) {
        String logo = "\n  OooOoo                         o\n"
                + "      O                         O \n"
                + "      o                         o \n"
                + "      O                         O \n"
                + "      o  .oOoO' `oOOoOO. .oOoO' o \n"
                + "      O  O   o   O  o  o O   o  O \n"
                + "O     o  o   O   o  O  O o   O  o \n"
                + "`OooOO'  `OoO'o  O  o  o `OoO'o Oo\n";

        System.out.println("Hey man it's your boy Jamal\n" + logo);
        System.out.println("Tell me anything, I gotchu");
        System.out.println("____________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[MAX_TASKS]; //using task class instead of string array
        int taskCount = 0;

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Aight bro, take care! Catch you later");
                System.out.println("____________________________________________________________");
                break;
            } else if (input.equals("list")) {
                System.out.println("____________________________________________________________");
                if (taskCount == 0) {
                    System.out.println("Hey man, you got nothing yet! Start adding tasks.");
                } else {
                    System.out.println("You got a lot to do boy:");
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + "." + tasks[i].getTaskDisplay());
                    }
                }
                System.out.println("____________________________________________________________");
                //marking tasks
            } else if (input.startsWith("mark ")) {
                try {
                    int taskIndex = Integer.parseInt(input.substring(5)) - 1;
                    if (taskIndex >= 0 && taskIndex < taskCount) {
                        tasks[taskIndex].markAsDone();
                        System.out.println("____________________________________________________________");
                        System.out.println("Lesgooo i've marked this task as done:");
                        System.out.println("  " + tasks[taskIndex].getTaskDisplay());
                        System.out.println("____________________________________________________________");
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
                    if (taskIndex >= 0 && taskIndex < taskCount) {
                        tasks[taskIndex].unmarkAsDone();
                        System.out.println("____________________________________________________________");
                        System.out.println("Damn i thought you finished it already, guess not:");
                        System.out.println("  " + tasks[taskIndex].getTaskDisplay());
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println("Bruh, that task number ain't valid.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Hey man, type a valid task number after 'unmark'.");
                }

            } else if (input.startsWith("todo ")) {
                String taskDescription = input.substring(5).trim();
                if (!taskDescription.isEmpty()) {
                    tasks[taskCount] = new ToDo(taskDescription);
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println("Got it! One more task for you:");
                    System.out.println("  " + tasks[taskCount - 1].getTaskDisplay());
                    System.out.println("Now you have " + taskCount + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("Hey man, ToDo task cannot be empty.");
                }

            } else if (input.startsWith("deadline ")) {
                try {
                    int byIndex = input.indexOf("/by");

                    if (byIndex == -1) { // if "/by" is missing, throw error
                        throw new Exception();
                    }

                    String taskDescription = input.substring(9, byIndex).trim();
                    String deadline = input.substring(byIndex + 4).trim();

                    tasks[taskCount] = new Deadline(taskDescription, deadline);
                    taskCount++;

                    System.out.println("____________________________________________________________");
                    System.out.println("Got it! One more task for you:");
                    System.out.println("  " + tasks[taskCount - 1].getTaskDisplay());
                    System.out.println("Now you got " + taskCount + " tasks in the list.");
                    System.out.println("____________________________________________________________");

                } catch (Exception e) {
                    System.out.println("Hey man, use the format: deadline <task> /by <time>");
                }
            } else if (input.startsWith("event ")) {
                try {
                    int fromIndex = input.indexOf("/from");
                    int toIndex = input.indexOf("/to");

                    if (fromIndex == -1 || toIndex == -1 || fromIndex > toIndex) {
                        throw new Exception();
                    }

                    String taskDescription = input.substring(6, fromIndex).trim();
                    String from = input.substring(fromIndex + 6, toIndex).trim();
                    String to = input.substring(toIndex + 4).trim();

                    tasks[taskCount] = new Event(taskDescription, from, to);
                    taskCount++;

                    System.out.println("____________________________________________________________");
                    System.out.println("Got it! One more task for you:");
                    System.out.println("  " + tasks[taskCount - 1].getTaskDisplay());
                    System.out.println("Now you got " + taskCount + " tasks in the list.");
                    System.out.println("____________________________________________________________");

                } catch (Exception e) {
                    System.out.println("Hey man, use the format: event <task> /from <start> /to <end>");
                }

            } else {
                if (taskCount < MAX_TASKS) {
                    tasks[taskCount] = new Task(input);
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println("Aight, added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Hey man, my memory full! Can't store more tasks.");
                    System.out.println("____________________________________________________________");
                }
            }
        }

        scanner.close();
    }
}
