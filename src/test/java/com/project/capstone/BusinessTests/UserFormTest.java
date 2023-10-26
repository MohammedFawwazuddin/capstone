package com.project.capstone.BusinessTests;
import com.project.capstone.business.UserForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserFormTest {

    private UserForm userForm;

    @BeforeEach
    void setUp() {
        userForm = new UserForm();
    }

    @Test
    void testGetName() {
        userForm.setName("testuser");

        assertEquals("testuser", userForm.getName());
    }

    @Test
    void testSetName() {
        userForm.setName("testuser");

        assertEquals("testuser", userForm.getName());
    }

    @Test
    void testGetPassword() {
        userForm.setPassword("testpassword");

        assertEquals("testpassword", userForm.getPassword());
    }

    @Test
    void testSetPassword() {
        userForm.setPassword("testpassword");

        assertEquals("testpassword", userForm.getPassword());
    }

    @Test
    void testGetPasswordRepeat() {
        userForm.setPasswordRepeat("testpassword");

        assertEquals("testpassword", userForm.getPasswordRepeat());
    }

    @Test
    void testSetPasswordRepeat() {
        userForm.setPasswordRepeat("testpassword");

        assertEquals("testpassword", userForm.getPasswordRepeat());
    }
}
