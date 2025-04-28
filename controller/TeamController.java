package com.example.ProjectManagement.controller;

import com.example.ProjectManagement.model.TeamMember;
import com.example.ProjectManagement.service.TeamMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {
    private final TeamMemberService teamMemberService;

    public TeamController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<TeamMember> addTeamMember(@RequestBody TeamMember teamMember) {
        return ResponseEntity.ok(teamMemberService.createTeamMember(teamMember));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'MANAGER')")
    public ResponseEntity<TeamMember> getTeamMember(@PathVariable Long id) {
        return ResponseEntity.ok(teamMemberService.getTeamMemberById(id));
    }
}
