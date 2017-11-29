package hu.elte.alkfejl.carhire.repository;

import hu.elte.alkfejl.carhire.model.Rent;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
    //Kölcsönzés keresése a kölcsönző személy azonosítója alapján:
    Optional<Rent> findByCustomerID(long customerID);

    //Kölcsönzés keresése az autó azonosítója alapján:
    Optional<Rent> findByCarID(long carID);
    
    //Kölcsönzés keresése az üzlet azonosítója alapján:
    Iterable<Rent> findByStoreID(long storeID);
    
    //Kölcsönzés keresése a kölcsönzést rendező alkalmazott azonosítója alapján:
    Iterable<Rent> findByEmployeeID(long employeeID);
}