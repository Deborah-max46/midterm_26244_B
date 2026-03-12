package com.example.consumer_voice_system.service;

import com.example.consumer_voice_system.entity.UserProfile;
import com.example.consumer_voice_system.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserProfileService {
    
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    // Save user profile
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
    
    // Get all user profiles
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }
    
    // Get user profile by ID
    public UserProfile getUserProfileById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }
}
