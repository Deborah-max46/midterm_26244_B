package com.example.consumer_voice_system.controller;

import com.example.consumer_voice_system.entity.UserProfile;
import com.example.consumer_voice_system.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {
    
    @Autowired
    private UserProfileService userProfileService;
    
    // Create user profile
    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile savedProfile = userProfileService.saveUserProfile(userProfile);
        return ResponseEntity.ok(savedProfile);
    }
    
    // Get all user profiles
    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        List<UserProfile> profiles = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(profiles);
    }
    
    // Get user profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long id) {
        UserProfile profile = userProfileService.getUserProfileById(id);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        }
        return ResponseEntity.notFound().build();
    }
}
