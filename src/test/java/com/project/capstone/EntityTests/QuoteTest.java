package com.project.capstone.EntityTests;

import com.project.capstone.Entity.Quote; // Import the Quote class you want to test
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class QuoteTest {

    private Quote quote;

    @BeforeEach
     void setUp() {
        quote = new Quote();
    }

    @Test
     void testGetId() {
        quote.setId(1L);
        assertEquals(1L, quote.getId());
    }

    @Test
     void testSetId() {
        quote.setId(2L);
        assertEquals(2L, quote.getId());
    }

    @Test
     void testGetCustomerName() {
        quote.setCustomerName("John Doe");
        assertEquals("John Doe", quote.getCustomerName());
    }

    @Test
     void testSetCustomerName() {
        quote.setCustomerName("Alice Smith");
        assertEquals("Alice Smith", quote.getCustomerName());
    }
}
