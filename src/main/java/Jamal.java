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

        System.out.println("Yo it's your boy Jamal\n" + logo);
        System.out.println("Tell me anything, I gotchu");
        System.out.println("____________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[100]; //array to store tasks
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
                    System.out.println("Yo bro, you got nothing yet! Start adding tasks.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");
            } else {
                if (taskCount < 100) {
                    tasks[taskCount] = input;
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println("Aight, added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Yo bro, my memory full! Can't store more tasks.");
                    System.out.println("____________________________________________________________");
                }
            }
        }

        scanner.close();
    }
}
