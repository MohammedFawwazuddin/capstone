package com.project.capstone.EntityTests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.capstone.Entity.Product;

public class ProductTest {
    private Product product;

    @BeforeEach
     void setUp() {
        product = new Product();
    }

    @Test
     void testSetName() {
        String name = "Sample Product Name";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @Test
     void testSetInternalName() {
        String internalName = "Internal Name";
        product.setInternalName(internalName);
        assertEquals(internalName, product.getInternalName());
    }

    @Test
     void testSetDetails() {
        String details = "Product details go here.";
        product.setDetails(details);
        assertEquals(details, product.getDetails());
    }

    @Test
     void testSetMaxProductsPerLocation() {
        int maxProductsPerLocation = 10;
        product.setMaxProductsPerLocation(maxProductsPerLocation);
        assertEquals(maxProductsPerLocation, product.getMaxProductsPerLocation());
    }
}
