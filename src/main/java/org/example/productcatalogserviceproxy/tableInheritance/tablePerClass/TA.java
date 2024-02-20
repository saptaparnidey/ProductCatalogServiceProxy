package org.example.productcatalogserviceproxy.tableInheritance.tablePerClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tpc_ta")
public class TA extends User {
    private String ratings;
}
