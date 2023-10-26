package com.project.capstone.BusinessTests;

import com.project.capstone.business.LoginBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginBodyTest {

    private LoginBody loginBody;

    @BeforeEach
    void setUp() {
        loginBody = new LoginBody();
    }

    @Test
    void testGetUsername() {
        loginBody.setUsername("testuser");
        assertEquals("testuser", loginBody.getUsername());
    }

    @Test
    void testSetUsername() {
        loginBody.setUsername("testuser");

        assertEquals("testuser", loginBody.getUsername());
    }

    @Test
    void testGetPassword() {
        loginBody.setPassword("testpassword");

        assertEquals("testpassword", loginBody.getPassword());
    }

    @Test
    void testSetPassword() {
        loginBody.setPassword("testpassword");

        assertEquals("testpassword", loginBody.getPassword());
    }
}


