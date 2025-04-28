package com.example.ProjectManagement.service;

import com.example.ProjectManagement.exception.ResourceNotFoundException;
import com.example.ProjectManagement.model.TaskAssignment;
import com.example.ProjectManagement.repository.TaskAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentService {
    private final TaskAssignmentRepository taskAssignmentRepository;

    public TaskAssignmentService(TaskAssignmentRepository taskAssignmentRepository) {
        this.taskAssignmentRepository = taskAssignmentRepository;
    }

    public List<TaskAssignment> getTasksByUser(Long userId) {
        return taskAssignmentRepository.findByUserId(userId);
    }

    public TaskAssignment getTaskAssignmentById(Long id) {
        return taskAssignmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task assignment not found with id: " + id));
    }

    public TaskAssignment assignTask(TaskAssignment taskAssignment) {
        return taskAssignmentRepository.save(taskAssignment);
    }
}
