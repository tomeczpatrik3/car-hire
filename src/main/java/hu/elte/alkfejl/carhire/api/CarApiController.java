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
@RequestMapping("/api/cars")
public class CarApiController {

    @Autowired
    private CarService carService;

    @GetMapping("/visitor")
    private ResponseEntity<Iterable<Car>> visitor() {
        Iterable<Car> cars = carService.listAll();
        return ResponseEntity.ok(cars);
    }
    
    @GetMapping("/makes")
    private ResponseEntity<Iterable<String>> makes() {
        Iterable<String> makes = carService.listMakes();
        return ResponseEntity.ok(makes);
    }
    
    @GetMapping("/models/{model}")
    private ResponseEntity<Iterable<String>> models(@PathVariable String model) {
        Iterable<String> models = carService.listModels(model);
        return ResponseEntity.ok(models);
    }    
}