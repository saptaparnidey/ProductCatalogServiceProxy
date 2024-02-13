package org.example.productcatalogserviceproxy.repository;

import org.example.productcatalogserviceproxy.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
}
