// package com.project.capstone.RepositoryTests;import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;
// import java.util.List;

// import com.project.capstone.repository.ProductRepository;
// import com.project.capstone.entity.Product;

// @ExtendWith(MockitoExtension.class)
// class ProductRepositoryTest {

//     @Test
//     void testFindByFeaturesContains() {
//         ProductRepository productRepository = mock(ProductRepository.class);

//         String feature = "Sample Feature";

//         Product sampleProduct = new Product();
//         sampleProduct.setId(1L);
//         sampleProduct.setName("Sample Product");
//         sampleProduct.addFeature(feature);

//         List<Product> products = List.of(sampleProduct);
//     }

//     @Test
//     void testFindByParametersContains() {
//         ProductRepository productRepository = mock(ProductRepository.class);
//         String parameter = "Sample Parameter";
//         Product sampleProduct = new Product();
//         sampleProduct.setId(1L);
//         sampleProduct.setName("Sample Product");
//         sampleProduct.addParameter(parameter);

//         List<Product> products = List.of(sampleProduct);

//     }
// }
