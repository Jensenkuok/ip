import java.util.Scanner;

public class Jamal {
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
        Task[] tasks = new Task[100]; //using task class instead of string array
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

            } else {
                if (taskCount < 100) {
                    tasks[taskCount] = new Task(input);
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println("Aight, added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Hey manbro, my memory full! Can't store more tasks.");
                    System.out.println("____________________________________________________________");
                }
            }
        }

        scanner.close();
    }
}
