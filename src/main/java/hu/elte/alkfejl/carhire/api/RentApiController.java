/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.api;

import hu.elte.alkfejl.carhire.dto.RentDTO;
import hu.elte.alkfejl.carhire.model.*;
import hu.elte.alkfejl.carhire.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author tomeczpatrik3
 */
@RestController
@RequestMapping("/api/rents")
public class RentApiController {

    @Autowired
    private RentService rentService;

    /*
        Az adatbázisban található kölcsönzések lekérdezéséhez:
    */
    @GetMapping("/visitor")
    private ResponseEntity<Iterable<RentDTO>> visitor() {
        Iterable<RentDTO> rents = rentService.listAll();
        return ResponseEntity.ok(rents);
    }
    
    /*
        Az adatbázisban található kölcsönzések dátumainak lekérdezéséhez:
    */
    @GetMapping("/dates")
    private ResponseEntity<Iterable<String>> dates() {
        Iterable<String> dates = rentService.listDates();
        return ResponseEntity.ok(dates);
    }
    
    /*
        Az adatbázisban egy adott névhez tartozó kölcsönzések lekérdezéséhez:
    */
    @GetMapping("list/customerName/{value}")
    private ResponseEntity<Iterable<RentDTO>> customerName(@PathVariable String value) {
        Iterable<RentDTO> rents = rentService.listByCustomerName(value);
        return ResponseEntity.ok(rents);
    }
    
    /*
        Az adatbázisban egy adott üzlethez tartozó kölcsönzések lekérdezéséhez:
    */
    @GetMapping("list/storeName/{value}")
    private ResponseEntity<Iterable<RentDTO>> storeName(@PathVariable String value) {
        Iterable<RentDTO> rents = rentService.listByStoreName(value);
        return ResponseEntity.ok(rents);
    }
    
    /*
        Az adatbázisban egy adott márkához tartozó kölcsönzések lekérdezéséhez:
    */
    @GetMapping("list/carMake/{value}")
    private ResponseEntity<Iterable<RentDTO>> carMake(@PathVariable String value) {
        Iterable<RentDTO> rents = rentService.listByMake(value);
        return ResponseEntity.ok(rents);
    }
    
    /*
        Az adatbázisban egy adott típushoz (modellhez) tartozó kölcsönzések lekérdezéséhez:
    */
    @GetMapping("list/carModel/{value}")
    private ResponseEntity<Iterable<RentDTO>> carModel(@PathVariable String value) {
        Iterable<RentDTO> rents = rentService.listByModel(value);
        return ResponseEntity.ok(rents);
    }
    
    /*
        Új kölcsönzés hozzáadásához
        Visszatérési érték:
            --> ResponseEntity.ok(saved): Ha sikeres az entitás felvétele
            --> HttpStatus.BAD_REQUEST: ha sikertelen az entitás felvétele
    */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    private ResponseEntity<Rent> add(@RequestBody RentDTO rentDTO) {
        if ( rentService.isValid(rentDTO) ) {
            Rent saved = rentService.save(rentDTO);
            return ResponseEntity.ok(saved);
        }
        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}