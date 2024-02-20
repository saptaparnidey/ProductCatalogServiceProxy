package org.example.productcatalogserviceproxy.tableInheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "msc_mentor")
public class Mentor extends User {
    private String numOfHours;
}
