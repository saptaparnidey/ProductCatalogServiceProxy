package org.example.productcatalogserviceproxy.service;

import org.example.productcatalogserviceproxy.dto.ProductDTO;
import org.example.productcatalogserviceproxy.model.Category;
import org.example.productcatalogserviceproxy.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private RestTemplateBuilder restTemplateBuilder;

    public ProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO[] productDTOs = restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDTO[].class).getBody();
        List<Product> products = new ArrayList<>();
        for(ProductDTO productDTO : productDTOs){
            products.add(getProduct(productDTO));
        }
        return products;
    }

    @Override
    public Product getProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO productDTO = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDTO.class, id).getBody();
        return getProduct(productDTO);
    }

    @Override
    public Product createProduct(ProductDTO productDTO){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO productDto = restTemplate.postForEntity("https://fakestoreapi.com/products", productDTO, ProductDTO.class).getBody();
        return getProduct(productDto);
    }

    @Override
    public String updateProduct(ProductDTO productDTO){
        return null;
    }

    @Override
    public String deleteProduct(Long id){
        return null;
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
