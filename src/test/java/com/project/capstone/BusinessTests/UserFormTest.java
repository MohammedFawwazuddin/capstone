package com.project.capstone.BusinessTests;

import com.project.capstone.business.UserForm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFormTest {

    @Test
    public void testUserFormGettersAndSetters() {
        UserForm userForm = new UserForm();

        userForm.setName("testUser");
        userForm.setPassword("password");
        userForm.setPasswordRepeat("password");

        assertEquals("testUser", userForm.getName());
        assertEquals("password", userForm.getPassword());
        assertEquals("password", userForm.getPasswordRepeat());
    }
}
