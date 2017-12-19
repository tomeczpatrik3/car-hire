/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.api;

import hu.elte.alkfejl.carhire.dto.EmployeeDTO;
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
@RequestMapping("/api/employees")
public class EmployeeApiController {

    @Autowired
    private EmployeeService employeeService;

    /*
        Az adatbázisban található alkalmazottak lekérdezéséhez:
    */
    @GetMapping("/visitor")
    private ResponseEntity<Iterable<EmployeeDTO>> visitor() {
        Iterable<EmployeeDTO> employees = employeeService.listAll();
        return ResponseEntity.ok(employees);
    }
}