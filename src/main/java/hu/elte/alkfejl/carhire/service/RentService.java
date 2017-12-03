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
}