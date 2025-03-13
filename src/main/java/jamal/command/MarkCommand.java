package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;
import jamal.ui.JamalUI;

public class MarkCommand extends Command {
    private final int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

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
