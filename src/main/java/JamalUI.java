public class JamalUI {
    private static final String LOGO = "\n  OooOoo                         o\n"
            + "      O                         O \n"
            + "      o                         o \n"
            + "      O                         O \n"
            + "      o  .oOoO' `oOOoOO. .oOoO' o \n"
            + "      O  O   o   O  o  o O   o  O \n"
            + "O     o  o   O   o  O  O o   O  o \n"
            + "`OooOO'  `OoO'o  O  o  o `OoO'o Oo\n";

    private static final String WELCOME_MESSAGE = "Hey man it's your boy Jamal\n" + LOGO +
            "\nTell me anything, I gotchu\n" +
            "____________________________________________________________";

    public static void showWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }
}
