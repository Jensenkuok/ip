package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;
import jamal.ui.JamalUI;

/**
 * Represents a command to mark a task as done.
 */
public class MarkCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a MarkCommand with the specified task index.
     *
     * @param taskIndex The index of the task to be marked as done.
     */
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the mark operation by setting the task as done.
     * Saves the updated task list to storage.
     *
     * @param tasks The task list containing the task to be marked.
     * @param storage The storage responsible for saving the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        if (!tasks.isValidIndex(taskIndex)) {
            System.out.println("Hey, that task number ain't valid.");
            return;
        }

        tasks.markTask(taskIndex);
        storage.saveTasks(tasks.getTasks());
        JamalUI.showSeparator();
        System.out.println("Lesgooo I've marked this task as done:");
        System.out.println("  " + tasks.getTasks().get(taskIndex).getTaskDisplay());
        JamalUI.showSeparator();
    }
}
