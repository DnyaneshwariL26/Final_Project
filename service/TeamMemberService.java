package com.example.ProjectManagement.service;

import com.example.ProjectManagement.exception.ResourceNotFoundException;
import com.example.ProjectManagement.model.TeamMember;
import com.example.ProjectManagement.repository.TeamMemberRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamMemberService {
    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberService(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    public TeamMember getTeamMemberById(Long id) {
        return teamMemberRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Team Member not found with id: " + id));
    }

    public TeamMember createTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }
}
