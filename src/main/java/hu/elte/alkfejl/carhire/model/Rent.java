package hu.elte.alkfejl.carhire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rent extends BaseEntity{

    @JoinColumn
    @ManyToOne(targetEntity = Customer.class, optional = false)
    @JsonIgnoreProperties("rents")
    @JsonIgnore
    private Customer customer;
    
    @JoinColumn
    @ManyToOne(targetEntity = Car.class, optional = false)
    @JsonIgnoreProperties("rents")
    @JsonIgnore
    private Car car;
    
    //A kölcsönzés dátuma:
    @Column(nullable = false)
    private String rentDate;  
    
    //A kölcsönzéshez tartozó megjegyzés:
    @Column(nullable = true)
    private String note;  
}
