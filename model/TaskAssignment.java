package com.example.ProjectManagement.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "task_assignments")
public class TaskAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime assignedDate;

    private LocalDateTime completedDate;

    private boolean completed;

    public TaskAssignment() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDateTime assignedDate) {
		this.assignedDate = assignedDate;
	}

	public LocalDateTime getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(LocalDateTime completedDate) {
		this.completedDate = completedDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "TaskAssignment [id=" + id + ", task=" + task + ", user=" + user + ", assignedDate=" + assignedDate
				+ ", completedDate=" + completedDate + ", completed=" + completed + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedDate, completed, completedDate, id, task, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskAssignment other = (TaskAssignment) obj;
		return Objects.equals(assignedDate, other.assignedDate) && completed == other.completed
				&& Objects.equals(completedDate, other.completedDate) && Objects.equals(id, other.id)
				&& Objects.equals(task, other.task) && Objects.equals(user, other.user);
	}

    // Getters, setters, equals, hashCode, and toString methods omitted for brevity
}
