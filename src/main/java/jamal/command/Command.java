package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;

public abstract class Command {
    public abstract void execute(TaskList tasks, Storage storage);
    public boolean isExit() {
        return this instanceof ExitCommand;
    }
}
