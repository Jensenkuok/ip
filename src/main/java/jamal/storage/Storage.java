package jamal.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import jamal.tasks.Deadline;
import jamal.tasks.Event;
import jamal.tasks.Task;
import jamal.tasks.ToDo;

/**
 * Handles loading and saving of tasks to a file.
 */
public class Storage {
    private static final String FILE_PATH = "data/duke.txt";

    /**
     * Handles loading and saving of tasks to a file.
     */
    public Storage() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            // Create directories and file if they don't exist
            if (file.getParentFile().mkdirs()) {
                System.out.println("Directory created: " + file.getParentFile().getAbsolutePath());
            }
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("Failed to create file.");
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }

    /**
     * Loads tasks from the storage file.
     *
     * @return A list of tasks loaded from the file.
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                switch (type) {
                case "T":
                    ToDo todo = new ToDo(description);
                    if (isDone) todo.markAsDone();
                    tasks.add(todo);
                    break;
                case "D":
                    String by = parts[3];
                    Deadline deadline = new Deadline(description, by);
                    if (isDone) deadline.markAsDone();
                    tasks.add(deadline);
                    break;
                case "E":
                    String[] fromTo = parts[3].split(" to ");
                    Event event = new Event(description, fromTo[0], fromTo[1]);
                    if (isDone) event.markAsDone();
                    tasks.add(event);
                    break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return tasks;
    }

    /**
     * Saves tasks to the storage file.
     *
     * @param tasks The list of tasks to save.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            for (Task task : tasks) {
                writer.write(taskToFileFormat(task) + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Converts a task into a formatted string for file storage.
     *
     * @param task The task to be formatted.
     * @return A formatted string representing the task for file storage.
     */
    private String taskToFileFormat(Task task) {
        String type;
        String status = task.isDone() ? "1" : "0";
        String description = task.getDescription();

        if (task instanceof ToDo) {
            type = "T";
            return type + " | " + status + " | " + description;
        } else if (task instanceof Deadline) {
            type = "D";
            return type + " | " + status + " | " + description + " | " + ((Deadline) task).getBy();
        } else if (task instanceof Event) {
            type = "E";
            return type + " | " + status + " | " + description + " | " + ((Event) task).getFrom() + " to " + ((Event) task).getTo();
        }
        return "";
    }
}
