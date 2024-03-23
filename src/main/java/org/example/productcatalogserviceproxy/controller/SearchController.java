package org.example.productcatalogserviceproxy.controller;

import org.example.productcatalogserviceproxy.dto.ProductDTO;
import org.example.productcatalogserviceproxy.dto.SeacrhRequestDTO;
import org.example.productcatalogserviceproxy.model.Product;
import org.example.productcatalogserviceproxy.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SeacrhRequestDTO seacrhRequestDTO){
//        List<Product> products = searchService.searchProducts(seacrhRequestDTO.getQuery(), seacrhRequestDTO.getPageNumber(), seacrhRequestDTO.getPageSize());
//        List<ProductDTO> searchResults = new ArrayList<>();
//        for(Product product : products){
//            searchResults.add(getProductDto(product));
//        }

        return searchService.searchProducts(seacrhRequestDTO.getQuery(), seacrhRequestDTO.getPageNumber(), seacrhRequestDTO.getPageSize());
    }

    private ProductDTO getProductDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategory(product.getCategory().getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
