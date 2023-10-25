package com.project.capstone.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.capstone.Entity.Location;
import com.project.capstone.Entity.Product;
import com.project.capstone.Entity.Quote;
import com.project.capstone.Entity.User;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.LocationService;
import com.project.capstone.service.ProductManagementService;
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

    private Long user_id;

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

   @GetMapping("/selectpage")
    public ResponseEntity<List<Quote>> selectAllQuotes() {
        List<Quote> quotes = quoteRepository.findAll();
        return ResponseEntity.ok(quotes);
    }
    @PostMapping("/selectpage")
    public ResponseEntity<Quote> storeQuote(@RequestBody Quote quote) {
        try {
            // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            // String username = authentication.getName();
            // Optional<User> loggedInUser = userRepository.findByName(username);
            // quote.setUser(loggedInUser.get());
            Quote savedQuote = quoteRepository.save(quote);
            System.out.println(savedQuote);
            return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
         }catch (Exception e) {
             e.printStackTrace(); // Log the exception for debugging
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // @PostMapping("/selectpage")
    // public ResponseEntity<Quote> storeQuote(@RequestBody Quote quote) {
    //     System.out.println(quote);
    //     try {
    //         // User user = userRepository.findById(user_id).get();
    //         // quote.setUser(user);
    //         Quote savedQuote = quoteRepository.save(quote);
    //         return ResponseEntity.ok(savedQuote);
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    //     }
    // }

    @PostMapping("/location/save")
    public ResponseEntity<String> saveLocation(@RequestBody Location location) {
        System.out.println(location.getLocation());
        System.out.println(location.getZipCode());
        System.out.println(location.getState());
        locationRepository.save(location);
        return ResponseEntity.ok("Location saved successfully");
    }

    @GetMapping("/location/get")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/selection")
    @ResponseBody
    public List<Product> productSelection(Model model) {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @RequestMapping("/products")
    public class ProductController {
        @Autowired
        private ProductManagementService productService;

        @GetMapping
        public List<Product> getAllProducts() {
            return (List<Product>) productService.getProduct(null);
        }
    }

    public void setUserRepository(UserRepository userRepository2) {
    }

    @GetMapping("/{productId}/details")
    public ResponseEntity<Product> getProductDetails(@PathVariable Long productId) {
        return null;
        // Retrieve and return product details by productId
    }

    @GetMapping("/{productId}/features")
    public ResponseEntity<List<Product>> getProductFeatures(@PathVariable Long productId) {
        return null;
        // Retrieve and return product features by productId
    }
}
