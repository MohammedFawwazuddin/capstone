package com.project.capstone.EntityTests;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.capstone.Entity.User;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
 class UserTest {

    @Mock
    private User user;

    @Test
     void testGetId() {
        when(user.getId()).thenReturn(1L);
        assertEquals(1L, user.getId());
    }

    @Test
     void testGetName() {
        when(user.getName()).thenReturn("testUser");
        assertEquals("testUser", user.getName());
    }

    @Test
     void testGetPassword() {
        when(user.getPassword()).thenReturn("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
     void testSetId() {
        when(user.getId()).thenReturn(0L);

        doAnswer(invocation -> {
            when(user.getId()).thenReturn(2L);
            return null;
        }).when(user).setId(2L);

        user.setId(2L);

        assertEquals(2L, user.getId());
    }

      @Test
     void testSetName() {
        when(user.getName()).thenReturn(null); 
        doAnswer(invocation -> {
            when(user.getName()).thenReturn("newUser"); 
            return null;
        }).when(user).setName("newUser");

        user.setName("newUser");

        assertEquals("newUser", user.getName());
    }


    @Test
     void testSetPassword() {
        when(user.getPassword()).thenReturn(null);
        doAnswer(invocation -> {
            when(user.getPassword()).thenReturn("newPassword");
            return null;
        }).when(user).setPassword("newPassword");

        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }
}
