package org.example.productcatalogserviceproxy.tableInheritance.joinedClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jc_instructor")
public class Instructor extends User {
    private String company;
}
