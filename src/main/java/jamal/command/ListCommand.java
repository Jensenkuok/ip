package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;
import jamal.ui.JamalUI;

/**
 * Represents a command to list all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Executes the list operation by displaying all tasks in the task list.
     *
     * @param tasks The task list to be displayed.
     * @param storage The storage (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        JamalUI.showSeparator();
        tasks.listTasks();
        JamalUI.showSeparator();
    }
}
