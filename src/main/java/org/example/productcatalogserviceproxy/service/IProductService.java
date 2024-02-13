package org.example.productcatalogserviceproxy.service;

import org.example.productcatalogserviceproxy.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product getProduct(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    String deleteProduct(Long id);
}
