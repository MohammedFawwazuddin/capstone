package com.project.capstone.BusinessTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.capstone.Entity.User;
import com.project.capstone.business.AuthAspect;
import com.project.capstone.business.LoggedInUser;
import com.project.capstone.business.NeedsAuth;

@ExtendWith(MockitoExtension.class)
public class AuthAspectTest {

    @InjectMocks
    private AuthAspect authAspect;

    @Mock
    private LoggedInUser loggedInUser;

    @Mock
    private ProceedingJoinPoint proceedingJoinPoint;

    @Mock
    private NeedsAuth needsAuth;

    @BeforeEach
    public void setUp() {
      
        reset(loggedInUser, proceedingJoinPoint, needsAuth);
    }

    @Test
    public void testDemandLoginWithLoggedInUser() throws Throwable {
        User mockUser = mock(User.class);
        when(loggedInUser.getLoggedInUser()).thenReturn(mockUser);

        Object result = authAspect.demandLogin(proceedingJoinPoint, needsAuth);
        assertEquals(result, proceedingJoinPoint.proceed());

        verifyNoMoreInteractions(needsAuth);
    }

    @Test
    public void testDemandLoginWithoutLoggedInUser() throws Throwable {
        when(loggedInUser.getLoggedInUser()).thenReturn(null);

        when(needsAuth.loginPage()).thenReturn("/login");

        Object result = authAspect.demandLogin(proceedingJoinPoint, needsAuth);

        assertEquals("redirect:/login", result);

        verify(loggedInUser, times(1)).getLoggedInUser();

        verify(needsAuth, times(1)).loginPage();
    }
}
