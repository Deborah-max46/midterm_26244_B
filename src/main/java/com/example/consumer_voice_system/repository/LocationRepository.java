package com.example.consumer_voice_system.repository;

import com.example.consumer_voice_system.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    // JpaRepository provides save() method for saving Location
}
