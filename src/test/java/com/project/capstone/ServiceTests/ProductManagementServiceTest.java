package com.project.capstone.ServiceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.capstone.entity.Product;
import com.project.capstone.repository.ProductRepository;
import com.project.capstone.service.ProductManagementService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagementServiceTest {

    @InjectMocks
    private ProductManagementService productManagementService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct_Success() {
        Product product = new Product();

        // Mock the save method of ProductRepository
        Mockito.when(productRepository.save(product)).thenReturn(product);

        // Call the addProduct method and check if it returns true
        boolean result = productManagementService.addProduct(product);

        assertTrue(result);
    }

    @Test
    public void testAddProduct_Failure() {
        Product product = new Product();

        // Mock the save method of ProductRepository to throw an exception
        Mockito.when(productRepository.save(product)).thenThrow(new RuntimeException("Test exception"));

        // Call the addProduct method and check if it returns false
        boolean result = productManagementService.addProduct(product);

        assertFalse(result);
    }

    @Test
    public void testGetProduct_Success() {
        long productId = 1L;
        Product product = new Product();

        // Mock the findById method of ProductRepository
        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // Call the getProduct method and check if it returns the expected product
        Product result = productManagementService.getProduct(productId);

        assertEquals(product, result);
    }

    @Test
    public void testGetProduct_NotFound() {
        long productId = 1L;

        // Mock the findById method of ProductRepository to return an empty Optional
        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Call the getProduct method and check if it returns null
        Product result = productManagementService.getProduct(productId);

        assertNull(result);
    }

    @Test
    public void testUpdateProduct_Success() {
        long productId = 1L;
        Product existingProduct = new Product();
        Product updatedProductDetails = new Product();

        // Mock the findById and save methods of ProductRepository
        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        Mockito.when(productRepository.save(existingProduct)).thenReturn(existingProduct);

        // Call the updateProduct method and check if it returns true
        boolean result = productManagementService.updateProduct(productId, updatedProductDetails);

        assertTrue(result);
    }

    @Test
    public void testUpdateProduct_ProductNotFound() {
        long productId = 1L;
        Product updatedProductDetails = new Product();

        // Mock the findById method of ProductRepository to return an empty Optional
        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Call the updateProduct method and check if it returns false
        boolean result = productManagementService.updateProduct(productId, updatedProductDetails);

        assertFalse(result);
    }

    @Test
    public void testUpdateProduct_Failure() {
        long productId = 1L;
        Product existingProduct = new Product();
        Product updatedProductDetails = new Product();

        // Mock the findById and save methods of ProductRepository
        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        Mockito.when(productRepository.save(existingProduct)).thenThrow(new RuntimeException("Test exception"));

        // Call the updateProduct method and check if it returns false
        boolean result = productManagementService.updateProduct(productId, updatedProductDetails);

        assertFalse(result);
    }
}
