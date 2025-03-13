package jamal;

import java.util.Scanner;

import jamal.command.Command;
import jamal.tasks.TaskList;
import jamal.logic.Parser;
import jamal.ui.JamalUI;
import jamal.storage.Storage;

public class Jamal {

    public static void main(String[] args) {

        JamalUI.showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage();
        TaskList tasks = new TaskList(storage.loadTasks());

        boolean isExit = false;
        while (!isExit) {
            String input = scanner.nextLine();
            Command command = Parser.parseCommand(input);

            if (command == null) {
                continue;  // Skip execution if the command is invalid
            }

            isExit = command.isExit();
            command.execute(tasks, storage);
        }

        scanner.close();
    }
}
