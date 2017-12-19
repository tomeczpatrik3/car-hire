/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.dto;

import hu.elte.alkfejl.carhire.model.Customer;
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
public class CustomerDTO {
    private long id;
    private String name;
    private String idNumber;
    private String birth;
    private String gender;
    private String address;
    private int joined;
    private int loans;
    
    public static CustomerDTO create(Customer cust) {
        return new CustomerDTO(
            cust.getId(),
            cust.getName(),
            cust.getIdNumber(),
            cust.getBirth(),
            cust.getGender(),
            cust.getAddress(),
            cust.getJoined(),
            cust.getLoans()
        );
    }        
}
