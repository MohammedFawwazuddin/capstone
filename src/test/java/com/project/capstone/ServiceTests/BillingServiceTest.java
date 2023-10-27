package com.project.capstone.ServiceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.capstone.entity.Billing;
import com.project.capstone.entity.User;
import com.project.capstone.repository.BillingRepository;
import com.project.capstone.service.BillingService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class BillingServiceTest {

    @Mock
    private BillingRepository billingRepository;

    @InjectMocks
    private BillingService billingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveBillingData() {
        Billing billing = new Billing();

        Mockito.when(billingRepository.save(billing)).thenReturn(billing);

        Billing savedBilling = billingService.saveBillingData(billing);
        assertEquals(billing, savedBilling);
    }

    @Test
     void testGetAllBillingData() {
        Billing billing1 = new Billing();
        Billing billing2 = new Billing();
        List<Billing> billingList = Arrays.asList(billing1, billing2);

        Mockito.when(billingRepository.findAll()).thenReturn(billingList);
        List<Billing> retrievedBillingList = billingService.getAllBillingData();
        assertEquals(billingList, retrievedBillingList);
    }

    // @Test
    // public void testGetTotalBillingAmount() {
    //     // Arrange
    //     long userId = 1L;
    //     List<Billing> billingList = Arrays.asList(
    //         new Billing(),
    //         new Billing()
    //     );

    //     Mockito.when(billingRepository.findById(userId)).thenReturn(billingList);

    //     // Act
    //     double totalAmount = billingService.getTotalBillingAmount(userId);

    //     // Assert
    //     assertEquals(30.0, totalAmount, 0.01); // Add an appropriate delta
    // }
}
