package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {
        tasks.findTasks(keyword);
    }
}
