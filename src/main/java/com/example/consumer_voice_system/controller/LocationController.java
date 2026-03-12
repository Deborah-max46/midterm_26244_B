package com.example.consumer_voice_system.controller;

import com.example.consumer_voice_system.dto.LocationCreateRequest;
import com.example.consumer_voice_system.entity.Location;
import com.example.consumer_voice_system.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    
    @Autowired
    private LocationService locationService;
    
    // Create location with parent code or name
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody LocationCreateRequest request) {
        Location savedLocation = locationService.createLocation(request);
        return ResponseEntity.ok(savedLocation);
    }
    
    // Get all locations
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }
    
    // Get location by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable UUID id) {
        Location location = locationService.getLocationById(id);
        if (location != null) {
            return ResponseEntity.ok(location);
        }
        return ResponseEntity.notFound().build();
    }
    
    // Get location by code
    @GetMapping("/code/{code}")
    public ResponseEntity<Location> getLocationByCode(@PathVariable String code) {
        Location location = locationService.getLocationByCode(code);
        if (location != null) {
            return ResponseEntity.ok(location);
        }
        return ResponseEntity.notFound().build();
    }
    
    // Get location by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Location> getLocationByName(@PathVariable String name) {
        Location location = locationService.getLocationByName(name);
        if (location != null) {
            return ResponseEntity.ok(location);
        }
        return ResponseEntity.notFound().build();
    }
}
