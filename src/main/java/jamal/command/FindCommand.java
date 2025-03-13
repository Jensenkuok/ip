package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;

/**
 * Represents a command to find tasks that contain a specified keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Constructs a FindCommand with the specified keyword.
     *
     * @param keyword The keyword used to search for tasks.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find operation by searching for tasks in the task list.
     *
     * @param tasks The task list to search within.
     * @param storage The storage (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        tasks.findTasks(keyword);
    }
}
