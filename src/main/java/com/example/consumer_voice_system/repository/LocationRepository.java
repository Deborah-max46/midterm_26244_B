package com.example.consumer_voice_system.repository;

import com.example.consumer_voice_system.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {
    // JpaRepository provides save() method for saving Location
    
    // Find location by code
    Optional<Location> findByCode(String code);
    
    // Find location by name
    Optional<Location> findByName(String name);
}
