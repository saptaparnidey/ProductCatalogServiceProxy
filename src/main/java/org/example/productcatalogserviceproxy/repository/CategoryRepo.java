package org.example.productcatalogserviceproxy.repository;

import org.example.productcatalogserviceproxy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{
}
