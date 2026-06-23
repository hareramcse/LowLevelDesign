package com.hs;

import java.time.LocalDate;

public class TaskManagementSystemTest {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        User user1 = new User("1", "John Doe", "john@example.com");
        User user2 = new User("2", "Jane Smith", "jane@example.com");

        Task task1 = new Task("1", "Task 1", "Description 1", LocalDate.now(), 1, user1);
        Task task2 = new Task("2", "Task 2", "Description 2", LocalDate.now(), 2, user2);
        Task task3 = new Task("3", "Task 3", "Description 3", LocalDate.now(), 1, user1);

        manager.createTask(task1);
        manager.createTask(task2);
        manager.createTask(task3);

        task2.setDescription("Updated description");
        manager.updateTask(task2);

        System.out.println("Search Results:");
        manager.searchTasks("Task").forEach(t -> System.out.println(t.title()));

        System.out.println("Filtered Tasks:");
        manager.filterTasks(TaskStatus.PENDING, 1).forEach(t -> System.out.println(t.title()));

        manager.markTaskAsCompleted("1");

        System.out.println("Task History for " + user1.name() + ":");
        manager.getTaskHistory(user1).forEach(t -> System.out.println(t.title()));

        manager.deleteTask("3");
    }
}
