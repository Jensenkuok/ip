package jamal.tasks;

import java.util.ArrayList;

/**
 * Represents a list of tasks and provides operations to modify it.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructs a TaskList with the given tasks.
     *
     * @param tasks The initial list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Hey! You got nothing yet! Start adding tasks.");
        } else {
            System.out.println("You got a lot to do boy:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + "." + tasks.get(i).getTaskDisplay());
            }
        }
    }

    /**
     * Marks the task at the specified index as done.
     *
     * @param taskIndex The index of the task to mark as done.
     */
    public void markTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            tasks.get(taskIndex).markAsDone();
        } else {
            System.out.println("Hey, that task number ain't valid.");
        }
    }

    /**
     * Unmarks the task at the specified index.
     *
     * @param taskIndex The index of the task to unmark.
     */
    public void unmarkTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            tasks.get(taskIndex).unmarkAsDone();
        } else {
            System.out.println("Hey, that task number ain't valid.");
        }
    }

    /**
     * Adds a ToDo task to the task list.
     *
     * @param taskDescription The description of the to-do task.
     * @return The newly added ToDo task.
     */
    public Task addTodoTask(String taskDescription) {
        Task newTask = new ToDo(taskDescription);
        tasks.add(newTask);
        return newTask;
    }

    /**
     * Adds a Deadline task to the task list.
     *
     * @param taskDescription The description of the deadline task.
     * @param deadline The due date of the task.
     * @return The newly added Deadline task.
     */
    public Task addDeadlineTask(String taskDescription, String deadline) {
        Task newTask = new Deadline(taskDescription, deadline);
        tasks.add(newTask);
        return newTask;
    }

    /**
     * Adds an Event task to the task list.
     *
     * @param taskDescription The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     * @return The newly added Event task.
     */
    public Task addEventTask(String taskDescription, String from, String to) {
        Task newTask = new Event(taskDescription, from, to);
        tasks.add(newTask);
        return newTask;
    }

    /**
     * Deletes a task from the task list.
     *
     * @param taskIndex The index of the task to be deleted.
     * @return The deleted task, or null if the index is invalid.
     */
    public Task deleteTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            return tasks.remove(taskIndex);
        } else {
            System.out.println("Hey, that task number ain't valid.");
            return null;
        }
    }

    /**
     * Finds and displays tasks that contain the specified keyword.
     *
     * @param keyword The keyword used to search for matching tasks.
     */
    public void findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }

        if (matchingTasks.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + "." + matchingTasks.get(i).getTaskDisplay());
            }
        }
    }

    /**
     * Retrieves the list of tasks.
     *
     * @return The list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Checks if the given index is a valid index within the task list.
     *
     * @param index The index to validate.
     * @return true if the index is within the valid range, otherwise false.
     */
    public boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}
