package com.project.capstone.ServiceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import com.project.capstone.Entity.User;
import com.project.capstone.Exception.QuotationBusinessException;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.UserService;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAuthenticateUserNotFound() {
        when(userRepository.findByName("nonExistentUser")).thenReturn(Optional.empty());

        assertThrows(QuotationBusinessException.class, () -> userService.authenticate("nonExistentUser", "password"));
    }

    @Test
    public void testAuthenticateInvalidPassword() {
        // Mock user data
        User user = new User();
        user.setId(1L);
        user.setName("testUser");
        user.setPassword("{bcrypt}hashedPassword");

        when(userRepository.findByName("testUser")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongPassword", "{bcrypt}hashedPassword")).thenReturn(false);

        Optional<User> authenticatedUser = userService.authenticate("testUser", "wrongPassword");

        assertFalse(authenticatedUser.isPresent());
    }
}