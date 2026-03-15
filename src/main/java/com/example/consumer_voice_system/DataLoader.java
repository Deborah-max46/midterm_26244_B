package com.example.consumer_voice_system;

import com.example.consumer_voice_system.dto.UserCreateRequest;
import com.example.consumer_voice_system.entity.*;
import com.example.consumer_voice_system.repository.*;
import com.example.consumer_voice_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private LocationRepository locationRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ComplaintRepository complaintRepository;
    
    @Autowired
    private ResponseRepository responseRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        // 1. Create Locations (Hierarchical Structure)
        
        // PROVINCE LEVEL
        Location kigaliProvince = new Location("Kigali City", "KGL", LocationLevel.PROVINCE);
        Location southernProvince = new Location("Southern Province", "SP", LocationLevel.PROVINCE);
        Location easternProvince = new Location("Eastern Province", "EP", LocationLevel.PROVINCE);
        locationRepository.saveAll(Arrays.asList(kigaliProvince, southernProvince, easternProvince));
        
        // DISTRICT LEVEL
        Location gasabo = new Location("Gasabo", "GAS", LocationLevel.DISTRICT);
        gasabo.setParent(kigaliProvince);
        
        Location huye = new Location("Huye", "HUY", LocationLevel.DISTRICT);
        huye.setParent(southernProvince);
        
        Location rwamagana = new Location("Rwamagana", "RWA", LocationLevel.DISTRICT);
        rwamagana.setParent(easternProvince);
        
        locationRepository.saveAll(Arrays.asList(gasabo, huye, rwamagana));
        
        // SECTOR LEVEL
        Location remera = new Location("Remera", "REM", LocationLevel.SECTOR);
        remera.setParent(gasabo);
        
        Location tumba = new Location("Tumba", "TUM", LocationLevel.SECTOR);
        tumba.setParent(huye);
        
        Location kigabiro = new Location("Kigabiro", "KIG", LocationLevel.SECTOR);
        kigabiro.setParent(rwamagana);
        
        locationRepository.saveAll(Arrays.asList(remera, tumba, kigabiro));
        
        // CELL LEVEL
        Location rukiriCell = new Location("Rukiri I", "RUK", LocationLevel.CELL);
        rukiriCell.setParent(remera);
        
        Location karamaCell = new Location("Karama", "KAR", LocationLevel.CELL);
        karamaCell.setParent(tumba);
        
        Location nyakarenzoCell = new Location("Nyakarenzo", "NYA", LocationLevel.CELL);
        nyakarenzoCell.setParent(kigabiro);
        
        locationRepository.saveAll(Arrays.asList(rukiriCell, karamaCell, nyakarenzoCell));
        
        // VILLAGE LEVEL
        Location nyabisindu = new Location("Nyabisindu", "NYB", LocationLevel.VILLAGE);
        nyabisindu.setParent(rukiriCell);
        
        Location ruhashya = new Location("Ruhashya", "RUH", LocationLevel.VILLAGE);
        ruhashya.setParent(karamaCell);
        
        Location kajevuba = new Location("Kajevuba", "KAJ", LocationLevel.VILLAGE);
        kajevuba.setParent(nyakarenzoCell);
        
        locationRepository.saveAll(Arrays.asList(nyabisindu, ruhashya, kajevuba));
        
        // 2. Create Users (link to VILLAGE level locations using codes)
        UserCreateRequest user1Request = new UserCreateRequest("Jean Uwimana", "jean@example.com", "pass123", "NYB", null);
        User user1 = userService.createUser(user1Request);
        
        UserCreateRequest user2Request = new UserCreateRequest("Marie Mukamana", "marie@example.com", "pass456", "RUH", null);
        User user2 = userService.createUser(user2Request);
        
        UserCreateRequest officialRequest = new UserCreateRequest("Paul Kagame", "official@gov.rw", "admin123", "NYB", null);
        User official = userService.createUser(officialRequest);
        
        // 3. Create User Profiles (One-to-One)
        UserProfile profile1 = new UserProfile("0788123456", "1199780012345678");
        profile1.setUser(user1);
        
        UserProfile profile2 = new UserProfile("0788654321", "1199885012345679");
        profile2.setUser(user2);
        
        userProfileRepository.saveAll(Arrays.asList(profile1, profile2));
        
        // 4. Create Categories
        Category waterSupply = new Category("Water Supply", "Issues related to water supply and distribution");
        Category electricity = new Category("Electricity", "Power outages and electrical issues");
        Category roads = new Category("Roads & Infrastructure", "Road maintenance and infrastructure problems");
        Category healthcare = new Category("Healthcare", "Hospital and health center issues");
        
        categoryRepository.saveAll(Arrays.asList(waterSupply, electricity, roads, healthcare));
        
        // 5. Create Complaints
        Complaint complaint1 = new Complaint("No water for 3 days", "Our sector has no water supply for the past 3 days");
        complaint1.setUser(user1);
        complaint1.setCategories(Arrays.asList(waterSupply));
        
        Complaint complaint2 = new Complaint("Frequent power outages", "Electricity goes off every evening");
        complaint2.setUser(user2);
        complaint2.setCategories(Arrays.asList(electricity));
        
        Complaint complaint3 = new Complaint("Damaged road", "Main road has big potholes causing accidents");
        complaint3.setUser(user1);
        complaint3.setCategories(Arrays.asList(roads));
        
        Complaint complaint4 = new Complaint("Water and road issues", "No water and damaged pipes on the road");
        complaint4.setUser(user2);
        complaint4.setCategories(Arrays.asList(waterSupply, roads)); // Multiple categories
        
        complaintRepository.saveAll(Arrays.asList(complaint1, complaint2, complaint3, complaint4));
        
        // 6. Create Responses
        Response response1 = new Response("We are working on fixing the water issue. Expected resolution in 2 days.");
        response1.setComplaint(complaint1);
        response1.setOfficial(official);
        
        Response response2 = new Response("Electricity team has been dispatched to investigate.");
        response2.setComplaint(complaint2);
        response2.setOfficial(official);
        
        Response response3 = new Response("Road maintenance scheduled for next week.");
        response3.setComplaint(complaint3);
        response3.setOfficial(official);
        
        responseRepository.saveAll(Arrays.asList(response1, response2, response3));
        
        System.out.println("✅ Sample data loaded successfully with hierarchical location structure!");
    }
}
