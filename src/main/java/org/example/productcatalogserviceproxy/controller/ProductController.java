package org.example.productcatalogserviceproxy.controller;

import org.example.productcatalogserviceproxy.dto.ProductDTO;
import org.example.productcatalogserviceproxy.model.Category;
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
    public ResponseEntity<List<Product>> getProducts(){
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
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        try {
            if(id < 1){
                throw new IllegalArgumentException("Product is invalid");
            }
            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("App-Name", "Product-Catalog-Service");
            return new ResponseEntity<>(productService.getProduct(id), headers, HttpStatus.OK);
        }
        catch (Exception e){
            throw e;
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO){
        Product product = getProduct(productDTO);
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        Product product = getProduct(productDTO);
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    private Product getProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImage());
        Category category = new Category();
        category.setName(productDTO.getTitle());
        category.setDescription(productDTO.getCategory());
        product.setCategory(category);
        return product;
    }
}
