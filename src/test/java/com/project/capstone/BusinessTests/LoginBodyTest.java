package com.project.capstone.BusinessTests;

import com.project.capstone.business.LoginBody;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class LoginBodyTest {

    @InjectMocks
    private LoginBody loginBody;

    @Test
    public void testGetUsername() {
        loginBody.setUsername("testUser");

        assert loginBody.getUsername().equals("testUser");
    }

    @Test
    public void testGetPassword() {
        loginBody.setPassword("password");

        assert loginBody.getPassword().equals("password");
    }

    @Test
    public void testSetUsername() {
        loginBody.setUsername("anotherUser");

        assert loginBody.getUsername().equals("anotherUser");
    }

    @Test
    public void testSetPassword() {
        loginBody.setPassword("12345");

        assert loginBody.getPassword().equals("12345");
    }
}

