package org.example.productcatalogserviceproxy.controller;

import org.example.productcatalogserviceproxy.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    private String getProducts(){
        return "Returning list of all products";
    }

    @GetMapping("{id}")
    private String getProduct(@PathVariable Long id){
        return "Returning product with id : " + id;
    }

    @PostMapping
    private String createProduct(@RequestBody ProductDTO productDTO){
        return "Creating Product -- " + productDTO;
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
