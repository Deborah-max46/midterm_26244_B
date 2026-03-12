package com.example.consumer_voice_system.dto;

public class UserCreateRequest {
    
    private String fullName;
    private String email;
    private String password;
    private String locationCode;  // Village code
    private String locationName;  // Village name
    
    // Constructors
    public UserCreateRequest() {
    }
    
    public UserCreateRequest(String fullName, String email, String password, String locationCode, String locationName) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.locationCode = locationCode;
        this.locationName = locationName;
    }
    
    // Getters and Setters
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
    
    public String getLocationCode() {
        return locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
    
    public String getLocationName() {
        return locationName;
    }
    
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
