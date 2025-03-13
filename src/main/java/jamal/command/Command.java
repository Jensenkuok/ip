package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.TaskList;

/**
 * Represents an abstract command that can be executed on a task list.
 * This is the base class for all specific command types.
 */
public abstract class Command {

    /**
     * Executes the command using the given task list and storage.
     *
     * @param tasks The task list on which the command is executed.
     * @param storage The storage instance responsible for saving tasks.
     */
    public abstract void execute(TaskList tasks, Storage storage);

    /**
     * Determines if this command is an exit command.
     *
     * @return true if the command is an instance of {@code ExitCommand}, otherwise false.
     */
    public boolean isExit() {
        return this instanceof ExitCommand;
    }
}
