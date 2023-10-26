package com.project.capstone.BusinessTests;
import org.junit.jupiter.api.Test;
import com.project.capstone.business.UserForm;
import static org.junit.jupiter.api.Assertions.assertEquals;
 class UserFormTest {

    @Test
     void testGettersAndSetters() {
        UserForm userForm = new UserForm();

        userForm.setName("TestUser");
        userForm.setPassword("TestPassword");
        userForm.setPasswordRepeat("TestPasswordRepeat");

        assertEquals("TestUser", userForm.getName());
        assertEquals("TestPassword", userForm.getPassword());
        assertEquals("TestPasswordRepeat", userForm.getPasswordRepeat());
    }
}
