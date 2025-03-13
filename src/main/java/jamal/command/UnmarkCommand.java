package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;
import jamal.ui.JamalUI;

/**
 * Represents a command to unmark a task as done.
 */
public class UnmarkCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     *
     * @param taskIndex The index of the task to be unmarked.
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the unmark operation by setting the task as not done.
     * Saves the updated task list to storage.
     *
     * @param tasks The task list containing the task to be unmarked.
     * @param storage The storage responsible for saving the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        if (!tasks.isValidIndex(taskIndex)) {
            System.out.println("Hey, that task number ain't valid.");
            return;
        }

        tasks.unmarkTask(taskIndex);
        storage.saveTasks(tasks.getTasks());
        JamalUI.showSeparator();
        System.out.println("Damn, I thought you finished it already, guess not:");
        System.out.println("  " + tasks.getTasks().get(taskIndex).getTaskDisplay());
        JamalUI.showSeparator();
    }
}
