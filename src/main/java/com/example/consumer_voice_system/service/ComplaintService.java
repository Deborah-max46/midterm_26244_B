package com.example.consumer_voice_system.service;

import com.example.consumer_voice_system.entity.Complaint;
import com.example.consumer_voice_system.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintService {
    
    @Autowired
    private ComplaintRepository complaintRepository;
    
    // Save complaint
    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }
    
    // Get all complaints (no pagination)
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }
    
    // Get all complaints with pagination and sorting
    public Page<Complaint> getAllComplaintsPaginated(Pageable pageable) {
        return complaintRepository.findAll(pageable);
    }
    
    // Get complaint by ID
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }
}
