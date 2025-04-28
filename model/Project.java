package com.example.ProjectManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is required")
    @Size(min = 3, max = 100, message = "Project name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @PastOrPresent(message = "Start date cannot be in the future")
    private LocalDate startDate;

    @FutureOrPresent(message = "End date cannot be in the past")
    private LocalDate endDate;

    private boolean active;

    @PositiveOrZero(message = "Budget must be zero or positive")
    private double budget;

    public Project() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", active=" + active + ", budget=" + budget + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, budget, description, endDate, id, name, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return active == other.active && Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget)
				&& Objects.equals(description, other.description) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(startDate, other.startDate);
	}

    // Getters, setters, equals, hashCode, and toString methods omitted for brevity
    
}
