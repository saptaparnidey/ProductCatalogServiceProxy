package org.example.productcatalogserviceproxy.service;

import org.example.productcatalogserviceproxy.model.Category;
import org.example.productcatalogserviceproxy.model.Product;
import org.example.productcatalogserviceproxy.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageProductService implements IProductService{

    private ProductRepo productRepo;

    public StorageProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepo.findAll();
        List<Product> result = new ArrayList<>();
        for(Product product : products){
            result.add(getProduct(product));
        }
        return result;
    }

    @Override
    public Product getProduct(Long id) {
        return getProduct(productRepo.getReferenceById(id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }

public Product getProduct(Product product){
        Product pd = new Product();
        pd.setId(product.getId());
        pd.setTitle(product.getTitle());
        pd.setDescription(product.getDescription());
        pd.setPrice(product.getPrice());
        Category category = new Category();
        category.setName(product.getCategory().getName());
        category.setDescription(product.getCategory().getDescription());
        pd.setCategory(category);
        return pd;
    }
}
