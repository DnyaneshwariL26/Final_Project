package com.example.ProjectManagement.repository;

import com.example.ProjectManagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId); // Retrieves tasks by project
}
