package org.example.productcatalogserviceproxy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productcatalogserviceproxy.model.Category;
import org.example.productcatalogserviceproxy.model.Product;

import java.util.List;

@Setter
@Getter
@ToString
public class CategoryDTO {
    private String name;
    private String description;
    private List<Product> products;
}
