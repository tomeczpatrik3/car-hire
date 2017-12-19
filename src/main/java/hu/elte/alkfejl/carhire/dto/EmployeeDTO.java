/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.dto;

import hu.elte.alkfejl.carhire.model.Employee;
import hu.elte.alkfejl.carhire.model.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author range
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long id;
    private String name;
    private String idNumber;
    private String birth;
    private String gender;
    private String address;
    private String storeName;
    private String recruitment;
    
    public static EmployeeDTO create(Employee emp) {
        String stores = "";
        for (int i=0; i<emp.getStores().size(); i++) {
            if (i==emp.getStores().size()-1)
                stores += i+1 + ". " + emp.getStores().get(i).getName() + "";
            else
                stores += i+1 + ". " + emp.getStores().get(i).getName() + ", ";
        }
        
        return new EmployeeDTO(
            emp.getId(),
            emp.getName(),
            emp.getIdNumber(),
            emp.getBirth(),
            emp.getGender(),
            emp.getAddress(),
            //A kölcsönző(k) neve:
            stores,
            emp.getRecruitment()
        );
    }    
}
