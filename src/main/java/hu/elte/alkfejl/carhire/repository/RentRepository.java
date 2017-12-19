package hu.elte.alkfejl.carhire.repository;

import hu.elte.alkfejl.carhire.model.Rent;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
 
    //Kölcsönzés keresése név alapján:
    Iterable<Rent> findByCustomerName(String customerName);
    
    //Kölcsönzés keresése márka alapján:
    Iterable<Rent> findByCarMake(String carMake);

    //Kölcsönzés keresése típus (modell) alapján:
    Iterable<Rent> findByCarModel(String carModel);
    
    //Kölcsönzés keresése a kölcsönző neve alapján:
    Iterable<Rent> findByCarStoreName(String storeName);

}