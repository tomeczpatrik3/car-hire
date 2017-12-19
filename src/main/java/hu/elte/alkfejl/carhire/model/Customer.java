package hu.elte.alkfejl.carhire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends Person { 

    @OneToMany(targetEntity = Rent.class, mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    @JsonIgnore
    private List<Rent> rents;
    
    //Tagság kezdete (év):
    @Column(nullable = false)
    private int joined;
    
    //Kölcsönzések száma:
    @Column(nullable = false)
    private int loans;
    
}
