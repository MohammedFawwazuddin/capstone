package com.project.capstone.ControllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.capstone.controller.ProjectController;
import com.project.capstone.entity.Location;
import com.project.capstone.entity.Product;
import com.project.capstone.entity.Quote;
import com.project.capstone.entity.User;
import com.project.capstone.repository.LocationRepository;
import com.project.capstone.repository.ProductRepository;
import com.project.capstone.repository.QuoteRepository;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.ProductManagementService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectControllerTest {

    @InjectMocks
    private ProjectController projectController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private QuoteRepository quoteRepository;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductManagementService productManagementService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // @Test
    // public void testRegisterUser_Success() {
    //     User user = new User();
    //     user.setName("TestUser");
    //     user.setPassword("TestPassword");
    
    //     // Mock the UserRepository's existsByName method to return false (user does not exist)
    //     Mockito.when(userRepository.existsByName(user.getName())).thenReturn(false);
    
    //     // Mock the UserRepository's save method to return the user
    //     Mockito.when(userRepository.save(user)).thenReturn(user);
    
    //     // Call the registerUser method
    //     ResponseEntity<String> response = projectController.registerUser(user);
    
    //     // Verify the response and that UserRepository methods were called
    //     assertEquals(HttpStatus.OK, response.getStatusCode());
    //     assertEquals("User registered successfully", response.getBody());
    //     Mockito.verify(userRepository).existsByName(user.getName());
    //     Mockito.verify(userRepository).save(user);
    // }
    

    @Test
    public void testRegisterUser_UserExists() {
        User user = new User();
        user.setName("TestUser");
        user.setPassword("TestPassword");

        // Mock the UserRepository's existsByName method
        Mockito.when(userRepository.existsByName(user.getName())).thenReturn(true);

        // Call the registerUser method
        ResponseEntity<String> response = projectController.registerUser(user);

        // Verify the response and that UserRepository method was called
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Username already exists", response.getBody());
        Mockito.verify(userRepository).existsByName(user.getName());
    }

    @Test
    public void testSelectAllQuotes() {
        List<Quote> quotes = new ArrayList<>();
        // Add quotes to the list

        // Mock the QuoteRepository's findAll method
        Mockito.when(quoteRepository.findAll()).thenReturn(quotes);

        // Call the selectAllQuotes method
        ResponseEntity<List<Quote>> response = projectController.selectAllQuotes();

        // Verify the response and that QuoteRepository method was called
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(quotes, response.getBody());
        Mockito.verify(quoteRepository).findAll();
    }

    @Test
    public void testStoreQuote_Success() {
        Quote quote = new Quote();

        // Mock the QuoteRepository's save method
        Mockito.when(quoteRepository.save(quote)).thenReturn(quote);

        // Call the storeQuote method
        ResponseEntity<Quote> response = projectController.storeQuote(quote);

        // Verify the response and that QuoteRepository method was called
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(quote, response.getBody());
        Mockito.verify(quoteRepository).save(quote);
    }

    @Test
    public void testStoreQuote_Error() {
        Quote quote = new Quote();

        // Mock the QuoteRepository's save method to throw an exception
        Mockito.when(quoteRepository.save(quote)).thenThrow(new RuntimeException("Test exception"));

        // Call the storeQuote method
        ResponseEntity<Quote> response = projectController.storeQuote(quote);

        // Verify the response and that QuoteRepository method was called
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(quoteRepository).save(quote);
    }

    @Test
    public void testSaveLocation() {
        Location location = new Location();

        // Call the saveLocation method
        ResponseEntity<String> response = projectController.saveLocation(location);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Location saved successfully", response.getBody());
    }

    @Test
    public void testGetAllLocations() {
        List<Location> locations = new ArrayList<>();
        // Add locations to the list

        // Mock the LocationRepository's findAll method
        Mockito.when(locationRepository.findAll()).thenReturn(locations);

        // Call the getAllLocations method
        ResponseEntity<List<Location>> response = projectController.getAllLocations();

        // Verify the response and that LocationRepository method was called
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(locations, response.getBody());
        Mockito.verify(locationRepository).findAll();
    }

    @Test
public void testProductSelection() {
    List<Product> products = new ArrayList<>();
    // Add products to the list

    // Mock the ProductRepository's findAll method
    Mockito.when(productRepository.findAll()).thenReturn(products);

    // Call the productSelection method
    List<Product> response = projectController.productSelection(null);

    // Verify the response and that ProductRepository method was called
    assertEquals(products, response);
    Mockito.verify(productRepository).findAll();
}

// @Test
// public void testGetAllProducts() {
//     List<Product> products = new ArrayList<>();
//     // Add products to the list

//     // Mock the ProductManagementService's getProduct method
//     Mockito.when(productManagementService.getProduct(null)).thenReturn(products);

//     // Call the getAllProducts method
//     List<Product> response = projectController.getAllProducts();

//     // Verify the response and that ProductManagementService method was called
//     assertEquals(products, response);
//     Mockito.verify(productManagementService).getProduct(null);
// }



// @Test
// public void testGetProductDetails() {
//     Long productId = 1L;

//     // Mock the behavior of the getProductDetails method
//     Product product = new Product(); // Create a sample product
//     Mockito.when(productManagementService.getProduct(productId)).thenReturn(product);

//     // Call the getProductDetails method
//     ResponseEntity<Product> response = projectController.getProductDetails(productId);

//     // Verify the response
//     assertEquals(HttpStatus.OK, response.getStatusCode());
//     // Add more specific assertions for the response content if needed
// }


    // @Test
    // public void testGetProductFeatures() {
    //     Long productId = 1L;

    //     // Call the getProductFeatures method
    //     ResponseEntity<List<Product>> response = projectController.getProductFeatures(productId);

    //     // Verify the response
    //     assertEquals(HttpStatus.OK, response.getStatusCode());
    //     // Add more specific assertions for the response content if needed
    // }

    @Test
    public void testCheckHealth() {
        // Call the checkhealth method
        String response = projectController.checkhealth();

        // Verify the response
        assertEquals("healthy", response);
    }
}
