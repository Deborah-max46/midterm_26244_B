package com.example.consumer_voice_system;

import com.example.consumer_voice_system.entity.*;
import com.example.consumer_voice_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private LocationRepository locationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
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
        
        // 1. Create Locations
        Location kigali = new Location("Kigali City", "KGL", "Gasabo", "Remera", "Rukiri I", "Nyabisindu");
        Location southern = new Location("Southern Province", "SP", "Huye", "Tumba", "Karama", "Ruhashya");
        Location eastern = new Location("Eastern Province", "EP", "Rwamagana", "Kigabiro", "Nyakarenzo", "Kajevuba");
        locationRepository.saveAll(Arrays.asList(kigali, southern, eastern));
        
        // 2. Create Users
        User user1 = new User("Jean Uwimana", "jean@example.com", "pass123");
        user1.setLocation(kigali);
        
        User user2 = new User("Marie Mukamana", "marie@example.com", "pass456");
        user2.setLocation(southern);
        
        User official = new User("Paul Kagame", "official@gov.rw", "admin123");
        official.setLocation(kigali);
        
        userRepository.saveAll(Arrays.asList(user1, user2, official));
        
        // 3. Create User Profiles (One-to-One)
        UserProfile profile1 = new UserProfile("0788123456", "1199780012345678", "Kigali, Gasabo, Remera, Rukiri I, Nyabisindu");
        profile1.setUser(user1);
        
        UserProfile profile2 = new UserProfile("0788654321", "1199885012345679", "Huye, Tumba, Karama, Ruhashya");
        profile2.setUser(user2);
        
        userProfileRepository.saveAll(Arrays.asList(profile1, profile2));
        
        // 4. Create Categories
        Category waterSupply = new Category("Water Supply", "Issues related to water supply and distribution");
        Category electricity = new Category("Electricity", "Power outages and electrical issues");
        Category roads = new Category("Roads & Infrastructure", "Road maintenance and infrastructure problems");
        Category healthcare = new Category("Healthcare", "Hospital and health center issues");
        
        categoryRepository.saveAll(Arrays.asList(waterSupply, electricity, roads, healthcare));
        
        // 5. Create Complaints
        Complaint complaint1 = new Complaint("No water for 3 days", "Our sector has no water supply for the past 3 days", LocalDate.of(2024, 1, 15));
        complaint1.setUser(user1);
        complaint1.setCategories(Arrays.asList(waterSupply));
        
        Complaint complaint2 = new Complaint("Frequent power outages", "Electricity goes off every evening", LocalDate.of(2024, 1, 16));
        complaint2.setUser(user2);
        complaint2.setCategories(Arrays.asList(electricity));
        
        Complaint complaint3 = new Complaint("Damaged road", "Main road has big potholes causing accidents", LocalDate.of(2024, 1, 17));
        complaint3.setUser(user1);
        complaint3.setCategories(Arrays.asList(roads));
        
        Complaint complaint4 = new Complaint("Water and road issues", "No water and damaged pipes on the road", LocalDate.of(2024, 1, 18));
        complaint4.setUser(user2);
        complaint4.setCategories(Arrays.asList(waterSupply, roads)); // Multiple categories
        
        complaintRepository.saveAll(Arrays.asList(complaint1, complaint2, complaint3, complaint4));
        
        // 6. Create Responses
        Response response1 = new Response("We are working on fixing the water issue. Expected resolution in 2 days.", LocalDate.of(2024, 1, 16));
        response1.setComplaint(complaint1);
        response1.setOfficial(official);
        
        Response response2 = new Response("Electricity team has been dispatched to investigate.", LocalDate.of(2024, 1, 17));
        response2.setComplaint(complaint2);
        response2.setOfficial(official);
        
        Response response3 = new Response("Road maintenance scheduled for next week.", LocalDate.of(2024, 1, 19));
        response3.setComplaint(complaint3);
        response3.setOfficial(official);
        
        responseRepository.saveAll(Arrays.asList(response1, response2, response3));
        
        System.out.println("✅ Sample data loaded successfully!");
    }
}
