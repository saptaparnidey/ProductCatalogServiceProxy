package org.example.productcatalogserviceproxy.controller;

import org.example.productcatalogserviceproxy.dto.ProductDTO;
import org.example.productcatalogserviceproxy.model.Product;
import org.example.productcatalogserviceproxy.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private ResponseEntity<List<Product>> getProducts(){
        try{
            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("App-Name", "Product-Catalog-Service");
            return new ResponseEntity<>(productService.getProducts(), headers, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("{id}")
    private ResponseEntity<Product> getProduct(@PathVariable Long id){
        try {
            if(id < 1){
                throw new IllegalArgumentException("Product is invalid");
            }
            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("App-Name", "Product-Catalog-Service");
            return new ResponseEntity<>(productService.getProduct(id), headers, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    private ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    private String updateProduct(@RequestBody ProductDTO productDTO){
        return "Updating Product -- " + productDTO;
    }

    @DeleteMapping("{id}")
    private String deleteProduct(@PathVariable Long id){
        return "Product deleted with id " + id;
    }
}
