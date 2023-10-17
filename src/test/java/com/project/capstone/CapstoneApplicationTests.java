package com.project.capstone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.capstone.Entity.Quote;
import com.project.capstone.Entity.User;
import com.project.capstone.controller.ProjectController;
import com.project.capstone.repository.LocationRepository;
import com.project.capstone.repository.ProductRepository;
import com.project.capstone.repository.QuoteRepository;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.LocationService;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CapstoneApplicationTests {

    @InjectMocks
    private ProjectController projectController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private QuoteRepository quoteRepository;

    @Mock
    private LocationService locationService;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void testRegisterUser_Success() {
        User user = new User();
        user.setName("testUser");
        user.setPassword("testPassword");

        when(userRepository.existsByName("testUser")).thenReturn(false);
        when(passwordEncoder.encode("testPassword")).thenReturn("encodedPassword");

        ResponseEntity<String> response = projectController.registerUser(user);

        verify(userRepository).save(user);
       assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testRegisterUser_UsernameExists() {
        User user = new User();
        user.setName("existingUser");
        user.setPassword("testPassword");

        when(userRepository.existsByName("existingUser")).thenReturn(true);

        ResponseEntity<String> response = projectController.registerUser(user);

        verify(userRepository, never()).save(user);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Username already exists", response.getBody());
    }

    @Test
    public void testStoreQuote_Success() {
        Quote quote = new Quote();

        when(quoteRepository.save(quote)).thenReturn(quote);

        ResponseEntity<Quote> response = projectController.storeQuote(quote);

        verify(quoteRepository).save(quote);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(quote, response.getBody());
    }

    @Test
    public void testStoreQuote_InternalServerError() {
        Quote quote = new Quote();

        when(quoteRepository.save(quote)).thenThrow(new RuntimeException("Some error"));

        ResponseEntity<Quote> response = projectController.storeQuote(quote);

        verify(quoteRepository).save(quote);
        assertEquals(500, response.getStatusCodeValue());
    }

    @Test
    public void testGetLocation_Success() {
        when(locationService.getLocationInfo()).thenReturn("Location Info");

        ResponseEntity<String> response = projectController.getLocation();

        verify(locationService).getLocationInfo();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Location Info", response.getBody());
    }

    // Similar tests for other methods can be added

}
