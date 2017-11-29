package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.model.Customer;
import hu.elte.alkfejl.carhire.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /*
        Új vásárló felvétele:
    */
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
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
}