package org.example.productcatalogserviceproxy.client.fakeStore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
    private FakeStoreRatingDto fakeStoreRatingDto;
}
