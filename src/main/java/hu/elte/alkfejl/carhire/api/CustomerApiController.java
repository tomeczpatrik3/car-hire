/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.api;

import hu.elte.alkfejl.carhire.dto.CustomerDTO;
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
@RequestMapping("/api/customers")
public class CustomerApiController {

    @Autowired
    private CustomerService customerService;

    /*
        Az adatabázisban található ügyfelek lekérdezéséhez:
    */
    @GetMapping("/visitor")
    private ResponseEntity<Iterable<CustomerDTO>> visitor() {
        Iterable<CustomerDTO> customers = customerService.listAll();
        return ResponseEntity.ok(customers);
    }
    
    /*
        Az adatabázisban található ügyfelek neveinek lekérdezéséhez:
    */
    @GetMapping("/names")
    private ResponseEntity<Iterable<String>> names() {
        Iterable<String> names = customerService.listNames();
        return ResponseEntity.ok(names);
    }
    
    /*
        Új ügyfél hozzáadásához
        Visszatérési érték:
            --> ResponseEntity.ok(saved): Ha sikeres az entitás felvétele
            --> HttpStatus.BAD_REQUEST: ha sikertelen az entitás felvétele
    */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    private ResponseEntity<Customer> add(@RequestBody CustomerDTO custDTO) {
        if (customerService.isValid(custDTO)) {
            Customer saved = customerService.save(custDTO);
            return ResponseEntity.ok(saved);
        }
        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}