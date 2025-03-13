package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;
import jamal.ui.JamalUI;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Storage storage) {
        JamalUI.showGoodbyeMessage();
    }
}
