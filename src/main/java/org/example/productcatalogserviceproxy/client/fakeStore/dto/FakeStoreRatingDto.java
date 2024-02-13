package org.example.productcatalogserviceproxy.client.fakeStore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FakeStoreRatingDto {
    private Double rate;
    private Long count;
}
