package com.example.consumer_voice_system.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Response {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String message;
    private LocalDate responseDate;
    
    // Many Responses belong to one Complaint (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;
    
    // Many Responses belong to one User (official) (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "official_id")
    private User official;
    
    // Constructors
    public Response() {
    }
    
    public Response(String message, LocalDate responseDate) {
        this.message = message;
        this.responseDate = responseDate;
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
