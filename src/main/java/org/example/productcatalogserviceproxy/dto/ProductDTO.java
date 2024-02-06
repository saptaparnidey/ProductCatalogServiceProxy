package org.example.productcatalogserviceproxy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productcatalogserviceproxy.model.Category;

@Setter
@Getter
@ToString
public class ProductDTO {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
