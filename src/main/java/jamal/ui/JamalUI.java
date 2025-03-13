package jamal.ui;

/**
 * Handles user interface interactions for the Jamal chatbot.
 */
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
    private static final String GOODBYE_MESSAGE = "Aight, take care! Catch you later";

    /**
     * Displays a separator line.
     */
    public static void showSeparator() {
        System.out.println(SEPARATOR);
    }
    private static final String WELCOME_MESSAGE = "Hey it's your boy Jamal\n" + LOGO +
            "\nTell me anything, I gotchu\n" + SEPARATOR;

    /**
     * Displays the welcome message.
     */
    public static void showWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    /**
     * Displays the goodbye message.
     */
    public static void showGoodbyeMessage() {
        System.out.println(GOODBYE_MESSAGE);
    }
}
