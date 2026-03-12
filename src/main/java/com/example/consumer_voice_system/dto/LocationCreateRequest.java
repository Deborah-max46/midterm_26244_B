package com.example.consumer_voice_system.dto;

public class LocationCreateRequest {
    
    private String name;
    private String code;
    private String level;
    private String parentCode;  // Parent location code
    private String parentName;  // Parent location name
    
    // Constructors
    public LocationCreateRequest() {
    }
    
    public LocationCreateRequest(String name, String code, String level, String parentCode, String parentName) {
        this.name = name;
        this.code = code;
        this.level = level;
        this.parentCode = parentCode;
        this.parentName = parentName;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getLevel() {
        return level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }
    
    public String getParentCode() {
        return parentCode;
    }
    
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
    
    public String getParentName() {
        return parentName;
    }
    
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
