package com.example.consumer_voice_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
    // Many-to-Many with Complaint
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Complaint> complaints = new ArrayList<>();
    
    // Constructors
    public Category() {
    }
    
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    // Getters and Setters
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
    
    public List<Complaint> getComplaints() {
        return complaints;
    }
    
    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }
}
