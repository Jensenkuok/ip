package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;
import jamal.ui.JamalUI;

public class UnmarkCommand extends Command {
    private final int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

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
