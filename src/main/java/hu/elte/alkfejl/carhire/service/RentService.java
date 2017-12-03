/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hu.elte.alkfejl.carhire.repository.RentRepository;
import java.util.ArrayList;

@Service
public class RentService {
    @Autowired
    private RentRepository rentRepository;

    /*
        Új kölcsönzés hozzáadása a rendszerhez:
    */
    public Rent addRent(Rent rent) {
        return rentRepository.save(rent);
    }
    /*
        Kölcsönzés törlése a rendszerből:
    */
    public void removeRent(Rent rent) {
        rentRepository.delete(rent);
    }
    /*
        Minden kölcsönzés kilistázása:
    */
    public Iterable<Rent> listAll() {
        return rentRepository.findAll();
    }
    
    /*
        Dátumok listázása:
    */
    public Iterable<String> listDates() {
        ArrayList<String> dates = new ArrayList<String>();
        
        Iterable<Rent> rents = rentRepository.findAll();
        
        for (Rent r : rents) {
            if (!dates.contains(r.getRentDate()))
                dates.add(r.getRentDate());
        }
        return dates;
    }
    
    public Iterable<Rent> listByCustomerName(String value) {
        return rentRepository.findByCustomerName(value);
    }
    
    public Iterable<Rent> listByMake(String value) {
        return rentRepository.findByCarMake(value);
    }
    
    public Iterable<Rent> listByModel(String value) {
        return rentRepository.findByCarModel(value);
    }
    
    public Iterable<Rent> listByStoreName(String value) {
        return rentRepository.findByStoreName(value);
    }
  
    public Iterable<Rent> listByRentDate(String value) {
        return rentRepository.findByRentDate(value);
    }
}