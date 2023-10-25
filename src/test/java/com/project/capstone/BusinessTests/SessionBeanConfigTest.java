package com.project.capstone.BusinessTests;

import com.project.capstone.business.LoggedInUser;
import com.project.capstone.business.SessionBeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SessionBeanConfig.class)
public class SessionBeanConfigTest {

    @Autowired
    private ApplicationContext context;

    @MockBean
    private LoggedInUser loggedInUser;

    @Test
    public void testSessionScopedBeanCreation() {
        assertNotNull(context.getBean(LoggedInUser.class));
    }

    @Test
    public void testSessionScopedBeanBehavior() {
        when(loggedInUser.getLoggedInUser()).thenReturn(null/* Create a User object or mock it */);

       LoggedInUser sessionScopedBean = context.getBean(LoggedInUser.class);

    }
}
