package com.example.consumer_voice_system.service;

import com.example.consumer_voice_system.entity.User;
import com.example.consumer_voice_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // Save user
    public User saveUser(User user) {
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
        return userRepository.findByLocationProvinceName(provinceName);
    }
    
    // Get users by province code
    public List<User> getUsersByProvinceCode(String provinceCode) {
        return userRepository.findByLocationProvinceCode(provinceCode);
    }
}
