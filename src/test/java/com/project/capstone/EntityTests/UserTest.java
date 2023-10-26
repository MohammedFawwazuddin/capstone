package com.project.capstone.EntityTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.capstone.entity.User;
import com.project.capstone.repository.UserRepository;

@SpringBootTest
public class UserTest {

    @Mock
    private UserRepository userRepository; // Assuming you have a UserRepository dependency

    private User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks

        // Create a sample user
        user = new User();
        user.setId(1L);
        user.setName("TestUser");
        user.setPassword("TestPassword");
    }

    @Test
    public void testGettersAndSetters() {
        // Test getter and setter methods
        assertEquals(1L, user.getId());
        assertEquals("TestUser", user.getName());
        assertEquals("TestPassword", user.getPassword());

        // Modify the user object using setters and verify the changes
        user.setId(2L);
        user.setName("UpdatedUser");
        user.setPassword("UpdatedPassword");

        assertEquals(2L, user.getId());
        assertEquals("UpdatedUser", user.getName());
        assertEquals("UpdatedPassword", user.getPassword());
    }

    @Test
    public void testSaveUser() {
        // Mock the UserRepository's save method
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        // Call the save method
        User savedUser = userRepository.save(user);

        // Verify that the save method was called and returned the expected user
        Mockito.verify(userRepository).save(user);
        assertEquals(user, savedUser);
    }
}
