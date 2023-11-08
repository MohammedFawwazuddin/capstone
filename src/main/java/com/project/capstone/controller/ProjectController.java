package com.project.capstone.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.BillingService;
import com.project.capstone.service.ProductManagementService;

import com.project.capstone.entity.Billing;
import com.project.capstone.entity.Feature;
import com.project.capstone.entity.Location;
import com.project.capstone.entity.Parameter;
import com.project.capstone.entity.Product;
import com.project.capstone.entity.Quote;
import com.project.capstone.entity.User;
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
    private QuoteRepository quoteRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillingService billingService;

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
            Quote savedQuote = quoteRepository.save(quote);
            return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/location/save")
    public ResponseEntity<String> saveLocation(@RequestBody Location location) {
        locationRepository.save(location);
        return ResponseEntity.ok("Location saved successfully");
    }

    @GetMapping("/location/get")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/selection")
    public ResponseEntity<List<Product>> productSelection() {
        List<Product> products = productRepository.findAll();
        if (!products.isEmpty()) {
            return ResponseEntity.ok().body(products);
        } else {
            return ResponseEntity.ok().body(Collections.emptyList());
        }
    }

    @GetMapping("/{productId}/details")
    public ResponseEntity<Product> getProductDetails(@PathVariable Long productId) {
        return getProductDetails(productId);
    }

    @GetMapping("/products/{productId}/features")
    public List<Feature> getProductFeatures(@PathVariable("productId") Long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        System.out.println(productOpt.get());
        productOpt.get().getFeatures().stream().forEach(feature -> System.out.println(feature.getName()+"bugga"));
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            return product.getFeatures();
        } else {
            return Collections.emptyList();
        }
    }

    @GetMapping("/products/{productId}/parameters")
    public List<Parameter> getProductParameters(@PathVariable("productId") Long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            return product.getFeatures().stream().map((a) -> a.getParameters().get(0)).toList();
        } else {
            return Collections.emptyList();
        }
    }

    // public List<Product> getAllProducts() {
    // return getAllProducts();
    // }

    @PostMapping("/billing")
    public ResponseEntity<String> saveBilling(@RequestBody Billing billingData) {
        // Authentication authentication =
        // SecurityContextHolder.getContext().getAuthentication();
        // User user = userRepository.findByName(authentication.getName()).get();
        // billingData.setUser(user);
        billingService.saveBillingData(billingData);
        return ResponseEntity.ok("Billing data saved successfully");
    }

    @GetMapping("/billing")
    public ResponseEntity<List<Billing>> getAllBillingData() {
        List<Billing> billingData = billingService.getAllBillingData();
        return ResponseEntity.ok(billingData);
    }

}