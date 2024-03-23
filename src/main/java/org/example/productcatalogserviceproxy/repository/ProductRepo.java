package org.example.productcatalogserviceproxy.repository;

import org.example.productcatalogserviceproxy.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

    Product findProductById(Long id);

    List<Product> findProductByPriceBetween(Double low, Double high);

    List<Product> findAllByOrderByIdDesc();

    List<Product> findAllByIsSpecialTrue();

    @Query("SELECT p.title FROM Product p WHERE p.id = ?1")
    String getProductTitleFromId(Long id);
    @Query("SELECT c.name FROM Product p JOIN Category c ON p.category.id = c.id WHERE p.id = :id")
    String getCategoryNameFromProductId(@Param("id") Long id);

    Page<Product> findByTitleEquals(String query, Pageable pageable);
}
