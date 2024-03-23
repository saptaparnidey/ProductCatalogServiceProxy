package org.example.productcatalogserviceproxy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeacrhRequestDTO {

    private String query;
    private Integer pageSize;
    private Integer pageNumber;
}
