package com.example.consumer_voice_system.controller;

import com.example.consumer_voice_system.entity.Complaint;
import com.example.consumer_voice_system.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {
    
    @Autowired
    private ComplaintService complaintService;
    
    // Create complaint
    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        Complaint savedComplaint = complaintService.saveComplaint(complaint);
        return ResponseEntity.ok(savedComplaint);
    }
    
    // Get all complaints (no pagination)
    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return ResponseEntity.ok(complaints);
    }
    
    // Get all complaints with pagination and sorting
    // Example: /api/complaints/paginated?page=0&size=5&sortBy=title&direction=ASC
    @GetMapping("/paginated")
    public ResponseEntity<Page<Complaint>> getAllComplaintsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction) {
        
        Sort sort = direction.equalsIgnoreCase("DESC") ? 
                    Sort.by(sortBy).descending() : 
                    Sort.by(sortBy).ascending();
        
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Complaint> complaints = complaintService.getAllComplaintsPaginated(pageable);
        return ResponseEntity.ok(complaints);
    }
    
    // Get complaint by ID
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        Complaint complaint = complaintService.getComplaintById(id);
        if (complaint != null) {
            return ResponseEntity.ok(complaint);
        }
        return ResponseEntity.notFound().build();
    }
}
