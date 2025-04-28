package com.example.ProjectManagement.service;

import com.example.ProjectManagement.exception.ResourceNotFoundException;
import com.example.ProjectManagement.exception.TaskException;
import com.example.ProjectManagement.model.TaskAssignment;
import com.example.ProjectManagement.model.Task;
import com.example.ProjectManagement.model.User;
import com.example.ProjectManagement.repository.TaskAssignmentRepository;
import com.example.ProjectManagement.repository.TaskRepository;
import com.example.ProjectManagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskAssignmentRepository taskAssignmentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskAssignmentRepository taskAssignmentRepository,
                       TaskRepository taskRepository,
                       UserRepository userRepository) {
        this.taskAssignmentRepository = taskAssignmentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public TaskAssignment assignTask(Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        if (task.isCompleted()) {
            throw new TaskException("Cannot assign a completed task.");
        }

        TaskAssignment taskAssignment = new TaskAssignment();
        taskAssignment.setTask(task);
        taskAssignment.setUser(user);
        taskAssignment.setAssignedDate(LocalDateTime.now());
        taskAssignment.setCompleted(false);

        return taskAssignmentRepository.save(taskAssignment);
    }

    @Transactional
    public TaskAssignment completeTask(Long taskAssignmentId) {
        TaskAssignment taskAssignment = taskAssignmentRepository.findById(taskAssignmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Task assignment not found with id: " + taskAssignmentId));

        if (taskAssignment.isCompleted()) {
            throw new TaskException("Task has already been completed.");
        }

        taskAssignment.setCompletedDate(LocalDateTime.now());
        taskAssignment.setCompleted(true);

        return taskAssignmentRepository.save(taskAssignment);
    }

    public List<TaskAssignment> getTasksByUser(Long userId) {
        return taskAssignmentRepository.findByUserId(userId);
    }
}
