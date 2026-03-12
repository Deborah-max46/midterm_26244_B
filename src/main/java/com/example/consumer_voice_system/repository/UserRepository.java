package com.example.consumer_voice_system.repository;

import com.example.consumer_voice_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Requirement: Implement existsByEmail() method
    boolean existsByEmail(String email);
    
    // Custom query to find users by province name (traverses hierarchy)
    @Query("SELECT u FROM User u WHERE " +
           "u.location.name = :name AND u.location.level = :level OR " +
           "u.location.parent.name = :name AND u.location.parent.level = :level OR " +
           "u.location.parent.parent.name = :name AND u.location.parent.parent.level = :level OR " +
           "u.location.parent.parent.parent.name = :name AND u.location.parent.parent.parent.level = :level OR " +
           "u.location.parent.parent.parent.parent.name = :name AND u.location.parent.parent.parent.parent.level = :level")
    List<User> findByLocationNameAndLocationLevel(@Param("name") String name, @Param("level") String level);
    
    // Custom query to find users by province code (traverses hierarchy)
    @Query("SELECT u FROM User u WHERE " +
           "u.location.code = :code AND u.location.level = :level OR " +
           "u.location.parent.code = :code AND u.location.parent.level = :level OR " +
           "u.location.parent.parent.code = :code AND u.location.parent.parent.level = :level OR " +
           "u.location.parent.parent.parent.code = :code AND u.location.parent.parent.parent.level = :level OR " +
           "u.location.parent.parent.parent.parent.code = :code AND u.location.parent.parent.parent.parent.level = :level")
    List<User> findByLocationCodeAndLocationLevel(@Param("code") String code, @Param("level") String level);
}
