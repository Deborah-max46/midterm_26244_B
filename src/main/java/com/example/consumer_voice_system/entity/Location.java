package com.example.consumer_voice_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;
    private String code;
    private String level; // PROVINCE, DISTRICT, SECTOR, CELL, VILLAGE
    
    // Self-referencing relationship (parent_id)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Location parent;
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Location> children = new ArrayList<>();
    
    // One Location has many Users (One-to-Many)
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users = new ArrayList<>();
    
    // Constructors
    public Location() {
    }
    
    public Location(String name, String code, String level) {
        this.name = name;
        this.code = code;
        this.level = level;
    }
    
    // Getters and Setters
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
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
    
    public Location getParent() {
        return parent;
    }
    
    public void setParent(Location parent) {
        this.parent = parent;
    }
    
    public List<Location> getChildren() {
        return children;
    }
    
    public void setChildren(List<Location> children) {
        this.children = children;
    }
    
    public List<User> getUsers() {
        return users;
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
