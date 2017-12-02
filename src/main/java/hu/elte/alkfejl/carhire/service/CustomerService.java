package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.model.Customer;
import hu.elte.alkfejl.carhire.repository.CustomerRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /*
        Új vásárló felvétele:
    */
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    /*
        Vásárló eltávolítása a rendszerből:
    */
    public void removeCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
    /*
        Minden ügyfél kilistázása:
    */
    public Iterable<Customer> listAll() {
        return customerRepository.findAll();
    }
    
    /*
        Ügyfelek neveinek kilistázása:
    */
    public Iterable<String> listNames() {
        ArrayList<String> names = new ArrayList<String>();
        Iterable<Customer> customers = customerRepository.findAll();
        
        for (Customer c : customers) {
            names.add(c.getName());
        }
        
        return names;
    }
    
    /*
        
    */
}