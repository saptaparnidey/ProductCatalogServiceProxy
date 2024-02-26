package org.example.productcatalogserviceproxy.controller;

import org.example.productcatalogserviceproxy.model.Product;
import org.example.productcatalogserviceproxy.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    public void test_GetProduct_ReturnProduct() {
        //Arrange
        Product product = new Product();
        product.setPrice(1000D);
        product.setTitle("Iphone15");

        when(productService.getProduct(any(Long.class))).thenReturn(product);

        //Act
        ResponseEntity<Product> productResponseEntity = productController.getProduct(1L);

        //Assert
        assertNotNull(productResponseEntity);
        assertEquals(1000D,productResponseEntity.getBody().getPrice());
        assertEquals("Iphone15",productResponseEntity.getBody().getTitle());
    }

    @Test
    public void test_GetProduct_InternalDependencyThrowsException() {
        //Arrange
        when(productService.getProduct(any(Long.class))).thenThrow(new RuntimeException("Something went wrong"));

        //Act and Assert
        assertThrows(RuntimeException.class,() -> productController.getProduct(1L));
    }

    @Test
    public void test_GetProductWithInvalidId_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> productController.getProduct(0L));
    }

}