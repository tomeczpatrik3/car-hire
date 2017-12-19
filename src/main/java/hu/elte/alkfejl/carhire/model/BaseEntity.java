package hu.elte.alkfejl.carhire.model;

import lombok.Data;
import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseEntity {

    /*
        Egyedi azonosító minden entitásnak:
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //GenerationType.SEQUENCE helyett
    private long id;

    /*
        Az entitáshoz tartozó verziószám:
    */
    @Version
    private long version;
}