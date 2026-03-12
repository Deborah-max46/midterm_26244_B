package com.example.consumer_voice_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String provinceName;
    private String provinceCode;
    private String district;
    private String sector;
    private String cell;
    private String village;
    
    // One Location has many Users (One-to-Many)
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users = new ArrayList<>();
    
    // Constructors
    public Location() {
    }
    
    public Location(String provinceName, String provinceCode, String district, String sector, String cell, String village) {
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
        this.district = district;
        this.sector = sector;
        this.cell = cell;
        this.village = village;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getProvinceName() {
        return provinceName;
    }
    
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    public String getProvinceCode() {
        return provinceCode;
    }
    
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    
    public String getDistrict() {
        return district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    
    public String getSector() {
        return sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    
    public String getCell() {
        return cell;
    }
    
    public void setCell(String cell) {
        this.cell = cell;
    }
    
    public String getVillage() {
        return village;
    }
    
    public void setVillage(String village) {
        this.village = village;
    }
    
    public List<User> getUsers() {
        return users;
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
