package org.example.productcatalogserviceproxy.repository;

import jakarta.transaction.Transactional;
import org.example.productcatalogserviceproxy.model.Category;
import org.example.productcatalogserviceproxy.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateLoading() {
        Category category = categoryRepo.findById(3L).get();
        System.out.println(category.getName());
        List<Product> products = category.getProducts();
        for(Product product : products) {
            System.out.println(product.getId());
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateFetchMode() {
        Category category = categoryRepo.findById(1L).get();
        System.out.println(category.getName());
//        List<Product> products = category.getProducts();
//        for(Product product : products) {
//            System.out.println(product.getId());
//        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateNplus1Problem() {
        List<Category> categories = categoryRepo.findAll();
        for(Category category : categories) {
            List<Product> products = category.getProducts();
            if(!products.isEmpty()) {
                System.out.println(products.get(0).getPrice());
            }
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateHowJPAGeneratesQueries() {
        Product product = productRepo.findProductById(3L);
        List<Product> findProductByPriceBetween = productRepo.findProductByPriceBetween(250D,2500D);
        List<Product> findAllByOrderByIdDesc = productRepo.findAllByOrderByIdDesc();
        List<Product> findAllByIsSpecialTrue = productRepo.findAllByIsSpecialTrue();
        System.out.println("debug");


    }
}
