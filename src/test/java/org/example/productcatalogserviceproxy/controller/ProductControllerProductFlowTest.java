package org.example.productcatalogserviceproxy.controller;

import org.example.productcatalogserviceproxy.dto.ProductDTO;
import org.example.productcatalogserviceproxy.model.Product;
import org.example.productcatalogserviceproxy.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductControllerProductFlowTest {

    @Autowired
    ProductController productController;

    @Autowired
    IProductService productService;

    @Test
    public void test_CreateAndFetchAndUpdate_RunsSuccessfully(){
        //Arrange
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setTitle("TestTitle");
        productDTO.setDescription("TestDesc");
        productDTO.setPrice(1000.0);

        //Act
        productController.createProduct(productDTO);
        ResponseEntity<Product> productResponseEntity = productController.getProduct(1L);
        productDTO.setTitle("AnotherTestTitle");
        productDTO.setPrice(1000.0);
        productController.updateProduct(1L, productDTO);
        ResponseEntity<Product> updatedProductResponseEntity = productController.getProduct(1L);

        //Assert
        assertEquals("TestTitle",productResponseEntity.getBody().getTitle());
        assertEquals("TestDesc", productResponseEntity.getBody().getDescription());
        assertEquals("AnotherTestTitle", updatedProductResponseEntity.getBody().getTitle());
        assertEquals(1000.0, updatedProductResponseEntity.getBody().getPrice());

    }
}
