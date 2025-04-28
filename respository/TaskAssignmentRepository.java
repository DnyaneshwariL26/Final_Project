package com.example.ProjectManagement.repository;

import com.example.ProjectManagement.model.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {
    List<TaskAssignment> findByUserId(Long userId); // Retrieves tasks assigned to a user
}
