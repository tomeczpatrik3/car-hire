package hu.elte.alkfejl.carhire.repository;


import hu.elte.alkfejl.carhire.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    //Keresés név alapján:
    Customer findByName(String name);
    
    //Keresés személyi alapján:
    Customer findByIdNumber(String idNumber);
    
    //Listázás tagság kezdete alapján:
    Iterable<Customer> findByJoined(int joined);

}