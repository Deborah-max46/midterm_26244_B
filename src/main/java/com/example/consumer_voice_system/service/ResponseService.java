package com.example.consumer_voice_system.service;

import com.example.consumer_voice_system.entity.Response;
import com.example.consumer_voice_system.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResponseService {
    
    @Autowired
    private ResponseRepository responseRepository;
    
    // Save response
    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }
    
    // Get all responses
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }
    
    // Get response by ID
    public Response getResponseById(Long id) {
        return responseRepository.findById(id).orElse(null);
    }
}
