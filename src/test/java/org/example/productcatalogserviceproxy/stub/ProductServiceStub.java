package org.example.productcatalogserviceproxy.stub;

import org.example.productcatalogserviceproxy.model.Product;
import org.example.productcatalogserviceproxy.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class ProductServiceStub implements IProductService {

    Map<Long, Product> products;

    public ProductServiceStub(){
        products = new HashMap<Long, Product>();
    }

    @Override
    public Product getProductDetails(Long userId, Long productId){
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(Long id) {
        return products.get(id);
    }

    @Override
    public Product createProduct(Product product) {
        products.put(product.getId(), product);
        return products.get(product.getId());

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        products.put(id,product);
        return products.get(id);
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
