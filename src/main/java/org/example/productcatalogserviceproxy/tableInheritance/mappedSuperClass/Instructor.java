package org.example.productcatalogserviceproxy.tableInheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "msc_instructor")
public class Instructor extends User {
    private String company;
}
