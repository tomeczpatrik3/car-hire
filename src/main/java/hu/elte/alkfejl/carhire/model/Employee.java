package hu.elte.alkfejl.carhire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person { 
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "STORES_EMPLOYEES",
        joinColumns = @JoinColumn(name = "employeeid", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "storeid", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Store> stores;

    //Felvétel dátuma:
    @Column(nullable = false)
    private String recruitment;    
}