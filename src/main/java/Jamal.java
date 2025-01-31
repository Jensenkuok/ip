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

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Aight bro, take care! Catch you later");
                System.out.println("____________________________________________________________");
                break;
            }

            System.out.println("____________________________________________________________");
            System.out.println("Yo, you said: " + input);
            System.out.println("____________________________________________________________");
        }

        scanner.close();
    }
}
