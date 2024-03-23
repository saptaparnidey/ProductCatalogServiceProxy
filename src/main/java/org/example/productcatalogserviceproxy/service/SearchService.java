package org.example.productcatalogserviceproxy.service;

import org.example.productcatalogserviceproxy.model.Product;
import org.example.productcatalogserviceproxy.repository.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Page<Product> searchProducts(String query, int pageNumber, int pageSize){
        Sort sort = Sort.by("price").and(Sort.by("id").descending());
        return productRepo.findByTitleEquals(query, PageRequest.of(pageNumber, pageSize, sort));
    }

}
