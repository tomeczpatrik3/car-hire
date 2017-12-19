package hu.elte.alkfejl.carhire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CARS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseEntity {
    @OneToMany(targetEntity = Rent.class, mappedBy = "car")
    @JsonIgnoreProperties("car")
    @JsonIgnore
    private List<Rent> rents;
    
    @JoinColumn
    @ManyToOne(targetEntity = Store.class, optional = false)
    @JsonIgnoreProperties("cars")
    @JsonIgnore
    private Store store;
    
    //Rendszám:
    @Column(nullable = false, unique = true)
    private String plateNumber;
    
    //Márka:
    @Column(nullable = false)
    private String make;

    //Típus:
    @Column(nullable = false)
    private String model;

    //Évjárat:
    @Column(nullable = false)
    private int year;
    
    //Szín:
    @Column(nullable = false)
    private String color;
    
    //Ajtók száma:
    @Column(nullable = false)
    private int doors;

    //Ülések száma:
    @Column(nullable = false)
    private int seats;
    
    //Ár/óra:
    @Column(nullable = false)
    private int price;
}