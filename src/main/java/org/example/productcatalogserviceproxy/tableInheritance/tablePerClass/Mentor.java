package org.example.productcatalogserviceproxy.tableInheritance.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tpc_mentor")
public class Mentor extends User {
    private String numOfHours;
}
