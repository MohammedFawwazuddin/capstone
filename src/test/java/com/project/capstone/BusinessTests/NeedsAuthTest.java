package com.project.capstone.BusinessTests;

import com.project.capstone.business.NeedsAuth;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NeedsAuthTest {

    @Test
    public void testNeedsAuthAnnotation() {
        NeedsAuth needsAuth = Mockito.mock(NeedsAuth.class);

        Mockito.when(needsAuth.loginPage()).thenReturn("/customLoginPage");

        assert needsAuth.loginPage().equals("/customLoginPage");
    }
}

