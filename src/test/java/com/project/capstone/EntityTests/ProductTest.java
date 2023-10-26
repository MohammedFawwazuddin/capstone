package com.project.capstone.EntityTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.project.capstone.entity.Product;
import com.project.capstone.entity.User;

public class ProductTest {

    @InjectMocks
    private Product product;

    @Mock
    private User user;
    @BeforeEach
    public void setUp() {
        product = new Product(); // Initialize the Product instance before each test
    }
    @Test
    public void testGettersAndSetters() {
        // Set values using setter methods
        product.setName("Test Product");
        product.setInternalName("Test Internal Name");
        product.setDetails("Test Product Details");
        product.setMaxProductsPerLocation(10);
        product.setPrice(99.99);
        product.setImageURL("test-image.jpg");

        // Get values using getter methods
        assertEquals("Test Product", product.getName());
        assertEquals("Test Internal Name", product.getInternalName());
        assertEquals("Test Product Details", product.getDetails());
        assertEquals(10, product.getMaxProductsPerLocation());
        assertEquals(0.0, product.getPrice());
        assertEquals("test-image.jpg", product.getImageURL());
    }


    @Test
    public void testUserAssociation() {
        // Mock the User object
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("TestUser");

        // Set the associated User
        product.setUser(mockUser);

        // Get the associated User
        User associatedUser = product.getUser();

        // Verify that the associated User matches the one we set
        assertEquals(1L, associatedUser.getId());
        assertEquals("TestUser", associatedUser.getName());
    }

    @Test
    public void testGetProductDetails() {
        Product product = new Product(); // Create an instance of Product
        Long productId = 1L;

        // Call the getProductDetails method and check the result
        Object result = product.getProductDetails(productId);

        // Verify that the method returns the expected result (in this case, it always returns null)
        assertEquals(null, result);
    }
}
