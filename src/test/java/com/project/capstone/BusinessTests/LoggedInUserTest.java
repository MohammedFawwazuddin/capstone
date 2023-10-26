package com.project.capstone.BusinessTests;

import com.project.capstone.business.LoggedInUser;
import com.project.capstone.entity.User;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
 class LoggedInUserTest {

    @InjectMocks
    private LoggedInUser loggedInUser;

    @Mock
    private User user;

    @Test
     void testGetLoggedInUser() {
     
        User mockUser = new User();
        mockUser.setName("testUser");
        mockUser.setPassword("password");

       
        loggedInUser.setLoggedInUser(mockUser);

       
        User result = loggedInUser.getLoggedInUser();
        assert result.getName().equals("testUser");
        assert result.getPassword().equals("password");
    }

    @Test
     void testSetLoggedInUser() {
      
        User mockUser = new User();
        mockUser.setName("anotherUser");
        mockUser.setPassword("12345");

        
        loggedInUser.setLoggedInUser(mockUser);

        
        User result = loggedInUser.getLoggedInUser();
        assert result.getName().equals("anotherUser");
        assert result.getPassword().equals("12345");
    }
}
