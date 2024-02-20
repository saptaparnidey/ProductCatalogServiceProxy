package org.example.productcatalogserviceproxy.tableInheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "msc_ta")
public class TA extends User {
    private String ratings;
}
