package org.example.productcatalogserviceproxy.tableInheritance.joinedClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jc_ta")
public class TA extends User {
    private String ratings;
}
