package com.example.consumer_voice_system.service;

import com.example.consumer_voice_system.dto.LocationCreateRequest;
import com.example.consumer_voice_system.entity.Location;
import com.example.consumer_voice_system.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;
    
    // Save Location
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }
    
    // Create location with parent code or name
    public Location createLocation(LocationCreateRequest request) {
        Location parent = null;
        
        // Try to find parent by code first
        if (request.getParentCode() != null && !request.getParentCode().isEmpty()) {
            parent = locationRepository.findByCode(request.getParentCode()).orElse(null);
        }
        
        // If not found by code, try by name
        if (parent == null && request.getParentName() != null && !request.getParentName().isEmpty()) {
            parent = locationRepository.findByName(request.getParentName()).orElse(null);
        }
        
        // Create location
        Location location = new Location(request.getName(), request.getCode(), request.getLevel());
        
        // Set parent if found
        if (parent != null) {
            location.setParent(parent);
        }
        
        return locationRepository.save(location);
    }
    
    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    // Get location by ID
    public Location getLocationById(UUID id) {
        return locationRepository.findById(id).orElse(null);
    }
    
    // Get location by code
    public Location getLocationByCode(String code) {
        return locationRepository.findByCode(code).orElse(null);
    }
    
    // Get location by name
    public Location getLocationByName(String name) {
        return locationRepository.findByName(name).orElse(null);
    }
}
