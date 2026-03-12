package com.example.consumer_voice_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Complaint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    
    @Column(updatable = false)
    private LocalDate submissionDate;
    
    @PrePersist
    protected void onCreate() {
        submissionDate = LocalDate.now();
    }
    
    // Many Complaints belong to one User (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    // One Complaint can have many Responses (One-to-Many)
    @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Response> responses = new ArrayList<>();
    
    // Many-to-Many with Category using join table complaint_category
    @ManyToMany
    @JoinTable(
        name = "complaint_category",
        joinColumns = @JoinColumn(name = "complaint_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();
    
    // Constructors
    public Complaint() {
    }
    
    public Complaint(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDate getSubmissionDate() {
        return submissionDate;
    }
    
    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public List<Response> getResponses() {
        return responses;
    }
    
    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
    
    public List<Category> getCategories() {
        return categories;
    }
    
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
