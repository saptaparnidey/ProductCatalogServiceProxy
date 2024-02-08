package org.example.productcatalogserviceproxy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RatingDTO {
    private Double rate;
    private Long count;
}
