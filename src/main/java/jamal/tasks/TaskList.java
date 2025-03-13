package jamal.tasks;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

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

    public void markTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            tasks.get(taskIndex).markAsDone();
        } else {
            System.out.println("Hey, that task number ain't valid.");
        }
    }

    public void unmarkTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            tasks.get(taskIndex).unmarkAsDone();
        } else {
            System.out.println("Hey, that task number ain't valid.");
        }
    }

    public Task addTodoTask(String taskDescription) {
        Task newTask = new ToDo(taskDescription);
        tasks.add(newTask);
        return newTask;
    }

    public Task addDeadlineTask(String taskDescription, String deadline) {
        Task newTask = new Deadline(taskDescription, deadline);
        tasks.add(newTask);
        return newTask;
    }

    public Task addEventTask(String taskDescription, String from, String to) {
        Task newTask = new Event(taskDescription, from, to);
        tasks.add(newTask);
        return newTask;
    }

    public Task deleteTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            return tasks.remove(taskIndex);
        } else {
            System.out.println("Hey, that task number ain't valid.");
            return null;
        }
    }

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

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}
