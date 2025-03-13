package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.Task;
import jamal.tasks.TaskList;
import jamal.ui.JamalUI;

public class DeleteCommand extends Command {
    private final int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

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
