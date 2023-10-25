package com.project.capstone.RepositoryTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.UserService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

 class UserRepositoryTest {

    @InjectMocks
    private UserService userService; 

    @Mock
    private UserRepository userRepository; 

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    //    @Test
    //  void testExistsByNameWhenUserDoesNotExist() {
    //     when(userRepository.existsByName("nonExistingUser")).thenReturn(false);

    //     boolean userExists = userService.checkIfUserExists("nonExistingUser");
    //     assertFalse(userExists);
    // }
}
