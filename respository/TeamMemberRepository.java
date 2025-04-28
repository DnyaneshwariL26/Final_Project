package com.example.ProjectManagement.repository;

import com.example.ProjectManagement.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
