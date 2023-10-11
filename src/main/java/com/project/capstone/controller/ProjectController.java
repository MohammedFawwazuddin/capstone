package com.project.capstone.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.capstone.Entity.User;
import com.project.capstone.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
    

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
            user.setRole(user.getRole());
            userRepository.save(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        }

    }
    
    private boolean userMatchesPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
}