package com.example.consumer_voice_system.controller;

import com.example.consumer_voice_system.dto.UserCreateRequest;
import com.example.consumer_voice_system.entity.User;
import com.example.consumer_voice_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    // Create user with location code or name
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) {
        User savedUser = userService.createUser(request);
        return ResponseEntity.ok(savedUser);
    }
    
    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
    
    // Check if email exists
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkEmailExists(@PathVariable String email) {
        boolean exists = userService.emailExists(email);
        return ResponseEntity.ok(exists);
    }
    
    // Get users by province name
    @GetMapping("/province/name/{provinceName}")
    public ResponseEntity<List<User>> getUsersByProvinceName(@PathVariable String provinceName) {
        List<User> users = userService.getUsersByProvinceName(provinceName);
        return ResponseEntity.ok(users);
    }
    
    // Get users by province code
    @GetMapping("/province/code/{provinceCode}")
    public ResponseEntity<List<User>> getUsersByProvinceCode(@PathVariable String provinceCode) {
        List<User> users = userService.getUsersByProvinceCode(provinceCode);
        return ResponseEntity.ok(users);
    }
}
