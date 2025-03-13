package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.Task;
import jamal.tasks.TaskList;
import jamal.ui.JamalUI;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a DeleteCommand with the specified task index.
     *
     * @param taskIndex The index of the task to be deleted.
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the delete operation by removing a task from the task list.
     * Saves the updated task list to storage.
     *
     * @param tasks The task list from which the task is deleted.
     * @param storage The storage responsible for saving the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        Task removedTask = tasks.deleteTask(taskIndex);
        if (removedTask != null) {
            storage.saveTasks(tasks.getTasks());
            JamalUI.showSeparator();
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask.getTaskDisplay());
            System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
            JamalUI.showSeparator();
        }
    }
}
