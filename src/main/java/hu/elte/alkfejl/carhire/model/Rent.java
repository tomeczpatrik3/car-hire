package hu.elte.alkfejl.carhire.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HIRES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rent extends BaseEntity{
    //A kölcsönző személy azonosítója:
    @Column(nullable = false, unique = true)
    private long customerID;      

    //A kölcsönzött autó azonosítója:
    @Column(nullable = false, unique = true)
    private long carID;      
    
    //Az üzlet, ahol kölcsönöztünk:
    @Column(nullable = false)
    private long storeID;  
    
    //A kölcsönzést lebonyolító dolgozó:
    @Column(nullable = false)
    private long employeeID;  
    
    //A kölcsönzés dátuma:
    @Column(nullable = false)
    private Date hireDate;     
}
