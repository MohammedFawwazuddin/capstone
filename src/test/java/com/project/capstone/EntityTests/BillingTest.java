package com.project.capstone.EntityTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.project.capstone.entity.Billing;
import com.project.capstone.entity.User;
import com.project.capstone.repository.BillingRepository;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.BillingService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

 class BillingTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BillingService billingService;
@Mock
    private BillingRepository billingRepository;    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        billingService = new BillingService(billingRepository);
    }

    @Test
     void testGetTotalBillingAmount() {
        // Arrange
        User user = new User();
        user.setId(1L);
        Billing billing1 = new Billing();
        billing1.setPrice(10.0);
        billing1.setUser(user);
        Billing billing2 = new Billing();
        billing2.setPrice(15.0);
        billing2.setUser(user);

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        double totalAmount = billingService.getTotalBillingAmount(1L);

        // Assert
        assertEquals(0.0, totalAmount, 0.01); // Add an appropriate delta
    }

    @Test
     void testGetTotalBillingAmount_UserNotFound() {
        // Arrange
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        double totalAmount = billingService.getTotalBillingAmount(1L);

        // Assert
        assertEquals(0.0, totalAmount, 0.01); // Add an appropriate delta
    }
}
