package com.project.capstone.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.capstone.Entity.Location;
import com.project.capstone.Entity.Product;
import com.project.capstone.Entity.Quote;
import com.project.capstone.Entity.User;
import com.project.capstone.business.LocationDTO;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.LocationService;
import com.project.capstone.repository.LocationRepository;
import com.project.capstone.repository.ProductRepository;
import com.project.capstone.repository.QuoteRepository;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private LocationService locationService; 

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private ProductRepository productRepository;

    
    @GetMapping("/health")
    public String checkhealth() {
        return "healthy";
    }
	
	@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {

            if (userRepository.existsByName(user.getName())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }
            
            user.setName(user.getName());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        }

    }

    @PostMapping("/selectpage")
    public ResponseEntity<Quote> storeQuote(@RequestBody Quote quote) {

        try {
            Quote savedQuote = quoteRepository.save(quote);
            return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/location")
    public ResponseEntity<String> getLocation() {
        try {
            String locationInfo = locationService.getLocationInfo();
            return ResponseEntity.ok(locationInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch location information");
        }
    }

    @PostMapping("/location")
public ResponseEntity<String> saveLocation(@RequestBody LocationDTO locationDTO) {
    Boolean status = locationService.saveLocation(locationDTO);
    if(status){
        return ResponseEntity.ok("Location Saved Successfully");
    }
    else{
        return ResponseEntity.status(404).body("Failed to save location");
    }
}
  @GetMapping("/selection")
    public String productSelection(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("selectedProducts", new ArrayList<Product>());
        return "product-selection";
    }

    

    private boolean userMatchesPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    public void setUserRepository(UserRepository userRepository2) {
    }
}