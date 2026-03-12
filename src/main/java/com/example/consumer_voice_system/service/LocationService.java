package com.example.consumer_voice_system.service;

import com.example.consumer_voice_system.entity.Location;
import com.example.consumer_voice_system.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;
    
    // Save Location
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }
    
    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    // Get location by ID
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }
}
