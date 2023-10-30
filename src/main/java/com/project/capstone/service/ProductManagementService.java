package com.project.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.capstone.entity.Product;
import com.project.capstone.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManagementService {

    @Autowired
    private static ProductRepository productRepository;

    public boolean addProduct(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public boolean updateProduct(Long productId, Product updatedProductDetails) {
        try {
            Product existingProduct = productRepository.findById(productId).orElse(null);
            if (existingProduct != null) {
                existingProduct.setName(updatedProductDetails.getName());
                existingProduct.setInternalName(updatedProductDetails.getInternalName());
                existingProduct.setDetails(updatedProductDetails.getDetails());
                existingProduct.setMaxProductsPerLocation(updatedProductDetails.getMaxProductsPerLocation());

                existingProduct.setFeatures(updatedProductDetails.getFeatures());
                existingProduct.setParameters(updatedProductDetails.getParameters());

                productRepository.save(existingProduct);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public List<String> getProductFeatures(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            return product.getFeatures();
        }
        return null;
    }

    public List<String> getProductParameters(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            return product.getParameters();
        }
        return null;
    }

     public boolean addParameter(Long productId, String parameter) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            List<String> parameters = product.getParameters();
            if (parameters == null) {
                parameters = new ArrayList<>();
            }
            parameters.add(parameter);
            product.setParameters(parameters);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    public static boolean addFeature(Long productId, String feature) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            List<String> features = product.getFeatures();
            if (features == null) {
                features = new ArrayList<>();
            }
            features.add(feature);
            product.setFeatures(features);
            productRepository.save(product);
            return true;
        }
        return false;
    }
}
