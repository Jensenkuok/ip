package jamal.command;

import jamal.storage.Storage;
import jamal.tasks.*;

public class AddCommand extends Command {
    private final String taskType;
    private final String description;
    private final String time1;  // Can be deadline or event 'from'
    private final String time2;  // Used for event 'to'

    public AddCommand(String taskType, String description, String time1, String time2) {
        this.taskType = taskType;
        this.description = description;
        this.time1 = time1;
        this.time2 = time2;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {
        Task addedTask = null;

        switch (taskType) {
        case "todo":
            addedTask = tasks.addTodoTask(description);
            break;
        case "deadline":
            addedTask = tasks.addDeadlineTask(description, time1);
            break;
        case "event":
            addedTask = tasks.addEventTask(description, time1, time2);
            break;
        }

        if (addedTask != null) {
            storage.saveTasks(tasks.getTasks());
            System.out.println("Got it! One more task for you:");
            System.out.println("  " + addedTask.getTaskDisplay());
            System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        }
    }
}