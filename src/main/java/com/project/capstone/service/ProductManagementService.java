package com.project.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capstone.entity.Feature;
import com.project.capstone.entity.Parameter;
import com.project.capstone.entity.Product;
import com.project.capstone.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManagementService {

    @Autowired
    private ProductRepository productRepository;

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
                // existingProduct.setParameters(updatedProductDetails.getParameters());

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
            List<Feature> features = product.getFeatures();
            List<String> featureNames = new ArrayList<>();
            for (Feature feature : features) {
                featureNames.add(feature.getName());
            }
            return featureNames;
        }
        return null;
    }
    

    public List<Parameter> getProductParameters(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            // return product.getParameters();
        }
        return null;
    }
    

    public boolean addParameter(Long productId, Parameter parameter) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            // // List<Parameter> parameters = product.getParameters();
            // if (parameters == null) {
            //     parameters = new ArrayList<>();
            // }
            // parameters.add(parameter);
            // product.setParameters(parameters);
            productRepository.save(product);
            return true;
        }
        return false;
    }
    

    public boolean addFeature(Long productId, Feature feature) {
    Product product = productRepository.findById(productId).orElse(null);
    if (product != null) {
        List<Feature> features = product.getFeatures();
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
