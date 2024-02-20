package org.example.productcatalogserviceproxy.tableInheritance.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tpc_instructor")
public class Instructor extends User {
    private String company;
}
