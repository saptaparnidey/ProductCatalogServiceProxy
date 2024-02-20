package org.example.productcatalogserviceproxy.tableInheritance.joinedClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jc_mentor")
public class Mentor extends User {
    private String numOfHours;
}
