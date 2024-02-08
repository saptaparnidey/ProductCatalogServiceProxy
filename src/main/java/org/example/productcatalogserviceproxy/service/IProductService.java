package org.example.productcatalogserviceproxy.service;

import org.example.productcatalogserviceproxy.dto.ProductDTO;
import org.example.productcatalogserviceproxy.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product getProduct(Long id);

    Product createProduct(ProductDTO productDTO);

    String updateProduct(ProductDTO productDTO);

    String deleteProduct(Long id);
}
