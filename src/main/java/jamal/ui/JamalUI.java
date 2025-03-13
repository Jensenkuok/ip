package jamal.ui;

public class JamalUI {
    private static final String LOGO = "\n  OooOoo                         o\n"
            + "      O                         O \n"
            + "      o                         o \n"
            + "      O                         O \n"
            + "      o  .oOoO' `oOOoOO. .oOoO' o \n"
            + "      O  O   o   O  o  o O   o  O \n"
            + "O     o  o   O   o  O  O o   O  o \n"
            + "`OooOO'  `OoO'o  O  o  o `OoO'o Oo\n";

    private static final String SEPARATOR = "____________________________________________________________";
    private static final String GOODBYE_MESSAGE = "Aight bro, take care! Catch you later";

    public static void showSeparator() {
        System.out.println(SEPARATOR);
    }
    private static final String WELCOME_MESSAGE = "Hey man it's your boy jamal.Jamal\n" + LOGO +
            "\nTell me anything, I gotchu\n" + SEPARATOR;

    public static void showWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }
    public static void showGoodbyeMessage() {
        showSeparator();
        System.out.println(GOODBYE_MESSAGE);
        showSeparator();
    }
}
