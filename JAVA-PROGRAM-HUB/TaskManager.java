import java.io.*;
import java.util.*;

class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    String title;
    String description;
    String dueDate;
    String priority;

    public Task(String title, String description, String dueDate, String priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nDue Date: " + dueDate + "\nPriority: " + priority;
    }
}

public class TaskManager {
    static Scanner sc = new Scanner(System.in);
    static List<Task> tasks = new ArrayList<>();
    static final String FILE_NAME = "tasks.dat";

    public static void main(String[] args) {
        loadTasks();

        while (true) {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task\n2. View Tasks\n3. Edit Task\n4. Delete Task\n5. Save and Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> editTask();
                case 4 -> deleteTask();
                case 5 -> {
                    saveTasks();
                    System.out.println("Tasks saved. Exiting.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter due date (yyyy-mm-dd): ");
        String due = sc.nextLine();
        System.out.print("Enter priority (Low/Medium/High): ");
        String priority = sc.nextLine();

        tasks.add(new Task(title, desc, due, priority));
        System.out.println("Task added.");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- Task List ---");
        int index = 1;
        for (Task task : tasks) {
            System.out.println("\nTask " + index++);
            System.out.println(task);
        }
    }

    static void editTask() {
        viewTasks();
        System.out.print("\nEnter task number to edit: ");
        int num = Integer.parseInt(sc.nextLine());

        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Task t = tasks.get(num - 1);
        System.out.print("Enter new title (leave blank to keep unchanged): ");
        String title = sc.nextLine();
        if (!title.isEmpty()) t.title = title;

        System.out.print("Enter new description (leave blank to keep unchanged): ");
        String desc = sc.nextLine();
        if (!desc.isEmpty()) t.description = desc;

        System.out.print("Enter new due date (leave blank to keep unchanged): ");
        String due = sc.nextLine();
        if (!due.isEmpty()) t.dueDate = due;

        System.out.print("Enter new priority (leave blank to keep unchanged): ");
        String priority = sc.nextLine();
        if (!priority.isEmpty()) t.priority = priority;

        System.out.println("Task updated.");
    }

    static void deleteTask() {
        viewTasks();
        System.out.print("\nEnter task number to delete: ");
        int num = Integer.parseInt(sc.nextLine());

        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(num - 1);
        System.out.println("Task deleted.");
    }

    static void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    static void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            tasks = new ArrayList<>(); // No tasks to load, start fresh
        }
    }
}
