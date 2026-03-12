package com.example.consumer_voice_system.repository;

import com.example.consumer_voice_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Requirement: Implement existsByEmail() method
    boolean existsByEmail(String email);
    
    // Requirement: Retrieve all users from a given province using provinceName
    List<User> findByLocationProvinceName(String provinceName);
    
    // Requirement: Retrieve all users from a given province using provinceCode
    List<User> findByLocationProvinceCode(String provinceCode);
}
