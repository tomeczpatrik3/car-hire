package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.dto.CustomerDTO;
import hu.elte.alkfejl.carhire.model.Customer;
import hu.elte.alkfejl.carhire.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    /*
        Vásárló eltávolítása a rendszerből:
    */
    public void removeCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
    /*
        Minden ügyfél kilistázása:
    */
    public Iterable<CustomerDTO> listAll() {
        return convertToDTOs( customerRepository.findAll() );
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
        Validalas:
    */
    public boolean isValid(CustomerDTO custDTO) {
        boolean l = true;
        
        //Név ellenőrzése:
        l = l && custDTO.getName().matches("^[A-Z][a-z]{2,15} [A-Z][a-z]{2,15}( [A-Z][a-z]{2,15}){0,3}");
        //Dátum ellenőrzése:
        l = l && custDTO.getBirth().matches("(19[0-9]{2}. [01][0-9]. [0-3][0-9].)|(20[0-1][0-9]. [01][0-9]. [0-3][0-9].)");
        //Cím ellenőrzése:
        l = l && custDTO.getAddress().matches("[0-9]{4},([ A-Za-z0-9,.]{2,15}){1,10}");
        //Személy ellenőrzése:
        l = l && custDTO.getIdNumber().matches("[0-9]{6}[A-Z]{2}");
        //Nem ellenőrzése:
        l = l && (custDTO.getGender().equals("Férfi") || custDTO.getGender().equals("Nő"));
        
        return l;
    }
    
    /*
        Adatok feldolgozhatóvá konvertálása:
    */
    public Iterable<CustomerDTO> convertToDTOs(Iterable<Customer> custs) {
        List<CustomerDTO> custDTOs = new ArrayList<>();
        for (Customer c : custs) {
            custDTOs.add( CustomerDTO.create(c) );
        }
        return  custDTOs;
    }
    

    /*
        Új vásárló felvétele:
    */
    public Customer save(CustomerDTO custDTO) {
        Customer cust = new Customer();
    
        cust.setName(custDTO.getName());
        cust.setIdNumber(custDTO.getIdNumber());
        cust.setBirth(custDTO.getBirth());
        cust.setGender(custDTO.getGender());
        cust.setAddress(custDTO.getAddress());
        cust.setJoined(custDTO.getJoined());
        cust.setLoans(custDTO.getLoans());

        return customerRepository.save(cust);
    }
}