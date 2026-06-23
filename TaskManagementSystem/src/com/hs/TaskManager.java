package com.hs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private final Map<String, Task> tasks = new HashMap<>();
    private final Map<String, List<Task>> userTasks = new HashMap<>();

    public void createTask(Task task) {
        tasks.put(task.id(), task);
        userTasks.computeIfAbsent(task.assignedUser().id(), k -> new ArrayList<>()).add(task);
    }

    public void updateTask(Task updated) {
        Task task = tasks.get(updated.id());
        if (task != null) {
            task.setTitle(updated.title());
            task.setDescription(updated.description());
        }
    }

    public void deleteTask(String taskId) {
        Task task = tasks.remove(taskId);
        if (task != null) {
            userTasks.getOrDefault(task.assignedUser().id(), List.of()).remove(task);
        }
    }

    public List<Task> searchTasks(String keyword) {
        return tasks.values().stream()
                .filter(t -> t.title().contains(keyword) || t.description().contains(keyword))
                .toList();
    }

    public List<Task> filterTasks(TaskStatus status, int priority) {
        return tasks.values().stream()
                .filter(t -> t.status() == status && t.priority() == priority)
                .toList();
    }

    public void markTaskAsCompleted(String taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setStatus(TaskStatus.COMPLETED);
        }
    }

    public List<Task> getTaskHistory(User user) {
        return List.copyOf(userTasks.getOrDefault(user.id(), List.of()));
    }
}
