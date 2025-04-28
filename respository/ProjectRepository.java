package com.example.ProjectManagement.repository;

import com.example.ProjectManagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByName(String name); // Ensures unique project names
}
