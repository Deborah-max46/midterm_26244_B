package com.example.consumer_voice_system.entity;

import jakarta.persistence.*;

@Entity
public class UserProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String phoneNumber;
    private String nationalId;
    private String address;
    
    // One-to-One with User
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
    
    // Constructors
    public UserProfile() {
    }
    
    public UserProfile(String phoneNumber, String nationalId, String address) {
        this.phoneNumber = phoneNumber;
        this.nationalId = nationalId;
        this.address = address;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getNationalId() {
        return nationalId;
    }
    
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}
