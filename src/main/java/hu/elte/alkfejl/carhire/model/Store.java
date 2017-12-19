package hu.elte.alkfejl.carhire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STORES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Store extends BaseEntity { 
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "STORES_EMPLOYEES",
        joinColumns = @JoinColumn(name = "storeid", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "employeeid", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Employee> employees;
    
    @OneToMany(targetEntity = Car.class, mappedBy = "store")
    @JsonIgnoreProperties("store")
    @JsonIgnore
    private List<Car> cars;
    
    //Név:
    @Column(nullable = false, unique = true)
    private String name;
    
    //Cím:
    @Column(nullable = false, unique = true)
    private String address;
    
    //Telefonszám:
    @Column(nullable = false, unique = true)
    private String phoneNumber;
}