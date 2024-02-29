package org.example.productcatalogserviceproxy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogserviceproxy.model.Product;
import org.example.productcatalogserviceproxy.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IProductService productService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void test_getProducts_ReceivesSuccessfulResponse() throws Exception {
        //Arrange
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setTitle("IPhone12");
        Product product2 = new Product();
        product2.setTitle("MacBook");
        productList.add(product);
        productList.add(product2);

        when(productService.getProducts()).thenReturn(productList);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(productList)))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[1].title").value("MacBook"));

    }

    @Test
    public void test_createProduct_ReceivesSuccessfulResponse() throws Exception {
        Product productToCreate = new Product();
        productToCreate.setTitle("Orange");
        productToCreate.setDescription("Fresh and Orange");

        Product expectedProduct = new Product();
        expectedProduct.setId(1000L);
        expectedProduct.setTitle("Orange");
        expectedProduct.setDescription("Fresh and Orange");

        when(productService.createProduct(any(Product.class))).thenReturn(expectedProduct);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productToCreate)))
                .andExpect(status().isCreated())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedProduct)))
                .andExpect(jsonPath("$.length()").value(10))
                .andExpect(jsonPath("$.title").value("Orange"));

    }
}