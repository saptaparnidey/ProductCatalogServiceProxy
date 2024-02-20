package org.example.productcatalogserviceproxy.tableInheritance.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "st_ta")
@DiscriminatorValue(value = "1")
public class TA extends User {
    private String ratings;
}
