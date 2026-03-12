package com.example.consumer_voice_system.controller;

import com.example.consumer_voice_system.entity.Response;
import com.example.consumer_voice_system.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {
    
    @Autowired
    private ResponseService responseService;
    
    // Create response
    @PostMapping
    public ResponseEntity<Response> createResponse(@RequestBody Response response) {
        Response savedResponse = responseService.saveResponse(response);
        return ResponseEntity.ok(savedResponse);
    }
    
    // Get all responses
    @GetMapping
    public ResponseEntity<List<Response>> getAllResponses() {
        List<Response> responses = responseService.getAllResponses();
        return ResponseEntity.ok(responses);
    }
    
    // Get response by ID
    @GetMapping("/{id}")
    public ResponseEntity<Response> getResponseById(@PathVariable Long id) {
        Response response = responseService.getResponseById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}
