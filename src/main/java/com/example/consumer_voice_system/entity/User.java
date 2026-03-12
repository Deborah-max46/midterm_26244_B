package com.example.consumer_voice_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fullName;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    // Many Users belong to one Location (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    
    // One User has one UserProfile (One-to-One)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private UserProfile userProfile;
    
    // One User can submit many Complaints (One-to-Many)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Complaint> complaints = new ArrayList<>();
    
    // One User (official) can write many Responses (One-to-Many)
    @OneToMany(mappedBy = "official", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Response> responses = new ArrayList<>();
    
    // Constructors
    public User() {
    }
    
    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public UserProfile getUserProfile() {
        return userProfile;
    }
    
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
    
    public List<Complaint> getComplaints() {
        return complaints;
    }
    
    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }
    
    public List<Response> getResponses() {
        return responses;
    }
    
    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
