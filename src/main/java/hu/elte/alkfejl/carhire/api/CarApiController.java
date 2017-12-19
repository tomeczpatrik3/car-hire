/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.api;

import hu.elte.alkfejl.carhire.dto.CarDTO;
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
@RequestMapping("/api/cars")
public class CarApiController {

    @Autowired
    private CarService carService;

    /*
        Az adatbázisban található autók lekérdezéséhez:
    */
    @GetMapping("/visitor")
    private ResponseEntity<Iterable<CarDTO>> visitor() {
        Iterable<CarDTO> cars = carService.listAll();
        return ResponseEntity.ok(cars);
    }
    
    /*
        Az adatbázisban található autók márkáinak lekérdezéséhez:
    */
    @GetMapping("/makes")
    private ResponseEntity<Iterable<String>> makes() {
        Iterable<String> makes = carService.listMakes();
        return ResponseEntity.ok(makes);
    }
    
    /*
        Egy adott márkához tartozó autó típusok (modellek) lekérdezéséhez:
    */
    @GetMapping("/models/{make}")
    private ResponseEntity<Iterable<String>> modelsByMake(@PathVariable String make) {
        Iterable<String> models = carService.listModelsByMake(make);
        return ResponseEntity.ok(models);
    }    
  
    /*
        Az összes autó típus (modell) lekérdezéséhez:
    */
    @GetMapping("/models")
    private ResponseEntity<Iterable<String>> models() {
        Iterable<String> models = carService.listModels();
        return ResponseEntity.ok(models);
    }   
}