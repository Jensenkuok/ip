package jamal.logic;

import java.util.ArrayList;

import jamal.storage.Storage;
import jamal.tasks.Deadline;
import jamal.tasks.Event;
import jamal.tasks.Task;
import jamal.tasks.ToDo;
import jamal.ui.JamalUI;

public class TaskManager {
    private final ArrayList<Task> tasks;
    private final Storage storage;

    public TaskManager() {
        this.storage = new Storage();
        this.tasks = storage.loadTasks();
    }

    public void listTasks() {
        JamalUI.showSeparator();
        if (tasks.isEmpty()) {
            System.out.println("Hey man, you got nothing yet! Start adding tasks.");
        } else {
            System.out.println("You got a lot to do boy:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + "." + tasks.get(i).getTaskDisplay());
            }
        }
        JamalUI.showSeparator();
    }

    public void markTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).markAsDone();
            storage.saveTasks(tasks);
            JamalUI.showSeparator();
            System.out.println("Lesgooo i've marked this task as done:");
            System.out.println("  " + tasks.get(taskIndex).getTaskDisplay());
            JamalUI.showSeparator();
        } else {
            System.out.println("Bruh, that task number ain't valid.");
        }
    }

    public void unmarkTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).unmarkAsDone();
            storage.saveTasks(tasks);
            JamalUI.showSeparator();
            System.out.println("Damn i thought you finished it already, guess not:");
            System.out.println("  " + tasks.get(taskIndex).getTaskDisplay());
            JamalUI.showSeparator();
        } else {
            System.out.println("Bruh, that task number ain't valid.");
        }
    }

    public void addTodoTask(String taskDescription) {
        tasks.add(new ToDo(taskDescription));
        storage.saveTasks(tasks);
        JamalUI.showSeparator();
        System.out.println("Got it! One more task for you:");
        System.out.println("  " + tasks.get(tasks.size() - 1).getTaskDisplay());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        JamalUI.showSeparator();
    }

    public void addDeadlineTask(String taskDescription, String deadline) {
        tasks.add(new Deadline(taskDescription, deadline));
        storage.saveTasks(tasks);
        JamalUI.showSeparator();
        System.out.println("Got it! One more task for you:");
        System.out.println("  " + tasks.get(tasks.size() - 1).getTaskDisplay());
        System.out.println("Now you got " + tasks.size() + " tasks in the list.");
        JamalUI.showSeparator();
    }

    public void addEventTask(String taskDescription, String from, String to) {
        tasks.add(new Event(taskDescription, from, to));
        storage.saveTasks(tasks);
        JamalUI.showSeparator();
        System.out.println("Got it! One more task for you:");
        System.out.println("  " + tasks.get(tasks.size() - 1).getTaskDisplay());
        System.out.println("Now you got " + tasks.size() + " tasks in the list.");
        JamalUI.showSeparator();
    }

    public void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task removedTask = tasks.remove(taskIndex);
            storage.saveTasks(tasks);
            JamalUI.showSeparator();
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask.getTaskDisplay());
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            JamalUI.showSeparator();
        } else {
            System.out.println("Bruh, that task number ain't valid.");
        }
    }

}
