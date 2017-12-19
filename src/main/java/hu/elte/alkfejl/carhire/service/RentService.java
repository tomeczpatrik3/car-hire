/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.dto.RentDTO;
import hu.elte.alkfejl.carhire.model.Car;
import hu.elte.alkfejl.carhire.model.Customer;
import hu.elte.alkfejl.carhire.model.Rent;
import hu.elte.alkfejl.carhire.repository.CarRepository;
import hu.elte.alkfejl.carhire.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hu.elte.alkfejl.carhire.repository.RentRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentService {
    @Autowired
    private RentRepository rentRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CarRepository carRepository;

    /*
        Kölcsönzés törlése a rendszerből:
    */
    public void removeRent(Rent rent) {
        rentRepository.delete(rent);
    }
    /*
        Minden kölcsönzés kilistázása:
    */
    public Iterable<RentDTO> listAll() {
        return convertToDTOs(rentRepository.findAll());
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
    
    /*
        Kölcsönzés keresése név alapján:
    */
    public Iterable<RentDTO> listByCustomerName(String value) {
        return convertToDTOs(rentRepository.findByCustomerName(value));
    }
    
    /*
        Kölcsönzés keresése márka alapján:
    */
    public Iterable<RentDTO> listByMake(String value) {
        return convertToDTOs(rentRepository.findByCarMake(value));
    }
    /*
        Kölcsönzés keresése típus (modell) alapján:
    */
    public Iterable<RentDTO> listByModel(String value) {
        return convertToDTOs(rentRepository.findByCarModel(value));
    }
    /*
        Kölcsönzés keresése a kölcsönző neve alapján:
    */
    public Iterable<RentDTO> listByStoreName(String value) {
        return convertToDTOs(rentRepository.findByCarStoreName(value));
    }
    /*
        Validálás:
    */
    public boolean isValid(RentDTO rentDTO) {
        boolean l = true;
        
        //Név ellenőrzése:
        l = l && rentDTO.getCustomerName().matches("^[A-Za-z]{2,15} [A-Za-z]{2,15}( [A-Za-z]{2,15})?");
        //Üzlet nevének ellenőrzése:
        l = l && rentDTO.getStoreName().matches("^[A-Za-z]{2,15}([ A-Za-z]{2,15})*");
        //Márka ellenőrzése:
        l = l && rentDTO.getCarMake().matches("^[A-Za-z]{2,15}([A-Za-z -]{2,15})*");
        //Autó típusának ellenőrzése:
        l = l && rentDTO.getCarModel().matches("^([A-Za-z0-9 ]{1,15})+");
        
        return l;
    }
    
    /*
        Adatok feldolgozhatóvá konvertálása:
    */
    public Iterable<RentDTO> convertToDTOs(Iterable<Rent> rents) {
        List<RentDTO> rentDTOs = new ArrayList<>();
        for (Rent r : rents) {
            rentDTOs.add( RentDTO.create(r) );
        }
        return  rentDTOs;
    }    
    
    /*
        Új kölcsönzés felvétele:
    */
    //TODO: Fixálni a http errort!
    public Rent save(RentDTO rentDTO) {
        Rent rent = new Rent();
    
        rent.setRentDate(rentDTO.getRentDate());
        rent.setNote(rentDTO.getNote());
        rent.setCar(carRepository.findByMakeAndModel(rentDTO.getCarMake(), rentDTO.getCarModel()));
        rent.setCustomer(customerRepository.findByName(rentDTO.getCustomerName()));
        
        return rentRepository.save(rent);
    }
}