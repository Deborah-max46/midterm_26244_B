package com.example.consumer_voice_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Response {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String message;
    
    @Column(updatable = false)
    private LocalDate responseDate;
    
    @PrePersist
    protected void onCreate() {
        responseDate = LocalDate.now();
    }
    
    // Many Responses belong to one Complaint (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "complaint_id")
    @JsonIgnore
    private Complaint complaint;
    
    // Many Responses belong to one User (official) (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "official_id")
    @JsonIgnore
    private User official;
    
    // Constructors
    public Response() {
    }
    
    public Response(String message) {
        this.message = message;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public LocalDate getResponseDate() {
        return responseDate;
    }
    
    public void setResponseDate(LocalDate responseDate) {
        this.responseDate = responseDate;
    }
    
    public Complaint getComplaint() {
        return complaint;
    }
    
    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    
    public User getOfficial() {
        return official;
    }
    
    public void setOfficial(User official) {
        this.official = official;
    }
}
