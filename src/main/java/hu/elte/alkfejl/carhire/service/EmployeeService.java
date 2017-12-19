package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.dto.EmployeeDTO;
import hu.elte.alkfejl.carhire.model.Employee;
import hu.elte.alkfejl.carhire.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /*
        Új alkalmazott felvétele a rendszerbe:
    */
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    /*
        ÚAlkalmazott eltávolítása a rendszerből:
    */
    public void removeEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
    
    /*
        Minden alkalmazott kilistázása:
    */
    public Iterable<EmployeeDTO> listAll() {
        return convertToDTOs( employeeRepository.findAll() );
    }

    /*
        Adatok feldolgozhatóvá konvertálása:
    */
    public Iterable<EmployeeDTO> convertToDTOs(Iterable<Employee> emps) {
        List<EmployeeDTO> empDTOs = new ArrayList<>();
        for (Employee e : emps) {
            empDTOs.add( EmployeeDTO.create(e) );
        }
        return  empDTOs;
    } 
}