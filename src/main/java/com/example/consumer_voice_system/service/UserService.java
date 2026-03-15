package com.example.consumer_voice_system.service;

import com.example.consumer_voice_system.dto.UserCreateRequest;
import com.example.consumer_voice_system.entity.Location;
import com.example.consumer_voice_system.entity.LocationLevel;
import com.example.consumer_voice_system.entity.User;
import com.example.consumer_voice_system.repository.LocationRepository;
import com.example.consumer_voice_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private LocationRepository locationRepository;
    
    // Save user
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    // Create user with location code or name
    public User createUser(UserCreateRequest request) {
        Location location = null;
        
        if (request.getLocationCode() != null && !request.getLocationCode().isEmpty()) {
            location = locationRepository.findByCode(request.getLocationCode()).orElse(null);
        }
        
        if (location == null && request.getLocationName() != null && !request.getLocationName().isEmpty()) {
            location = locationRepository.findByName(request.getLocationName()).orElse(null);
        }
        
        if (location == null) {
            throw new RuntimeException("Location not found with code: " + request.getLocationCode() + " or name: " + request.getLocationName());
        }
        
        User user = new User(request.getFullName(), request.getEmail(), request.getPassword());
        user.setLocation(location);
        
        return userRepository.save(user);
    }
    
    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    // Check if email exists
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
    
    // Get users by province name
    public List<User> getUsersByProvinceName(String provinceName) {
        return userRepository.findByLocationNameAndLocationLevel(provinceName, LocationLevel.PROVINCE);
    }
    
    // Get users by province code
    public List<User> getUsersByProvinceCode(String provinceCode) {
        return userRepository.findByLocationCodeAndLocationLevel(provinceCode, LocationLevel.PROVINCE);
    }
}
