package com.hs;

import java.time.LocalDate;

public class Task {
    private final String id;
    private String title;
    private String description;
    private final LocalDate dueDate;
    private final int priority;
    private TaskStatus status;
    private final User assignedUser;

    public Task(String id, String title, String description, LocalDate dueDate, int priority, User assignedUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
        this.assignedUser = assignedUser;
    }

    public String id() { return id; }
    public String title() { return title; }
    public String description() { return description; }
    public LocalDate dueDate() { return dueDate; }
    public int priority() { return priority; }
    public TaskStatus status() { return status; }
    public User assignedUser() { return assignedUser; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(TaskStatus status) { this.status = status; }
}
