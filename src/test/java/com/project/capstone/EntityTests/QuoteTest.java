package com.project.capstone.EntityTests;

import org.junit.jupiter.api.Test;

import com.project.capstone.entity.Quote;
import com.project.capstone.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class QuoteTest {

    @Test
     void testGettersAndSetters() {
        Quote quote = new Quote();

        quote.setCustomerName("John Doe");
        quote.setAccountStatus("Active");
        quote.setQuoteName("Test Quote");
        quote.setQuoteOwner("Owner");
        quote.setQuoteId("12345");

        assertEquals("John Doe", quote.getCustomerName());
        assertEquals("Active", quote.getAccountStatus());
        assertEquals("Test Quote", quote.getQuoteName());
        assertEquals("Owner", quote.getQuoteOwner());
        assertEquals("12345", quote.getQuoteId());
    }

    @Test
     void testUserAssociation() {
        Quote quote = new Quote();
        User user = new User();
        user.setName("TestUser");

        quote.setUser(user);

        User associatedUser = quote.getUser();

        assertEquals("TestUser", associatedUser.getName());
    }
}
