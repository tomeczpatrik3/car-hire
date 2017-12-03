/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.api;

import hu.elte.alkfejl.carhire.model.*;
import hu.elte.alkfejl.carhire.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/visitor")
    private ResponseEntity<Iterable<Rent>> visitor() {
        Iterable<Rent> rents = rentService.listAll();
        return ResponseEntity.ok(rents);
    }
  
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    private ResponseEntity<Rent> add(@RequestBody Rent rent) {
        Rent saved = rentService.addRent(rent);
        return ResponseEntity.ok(saved);
    }
}