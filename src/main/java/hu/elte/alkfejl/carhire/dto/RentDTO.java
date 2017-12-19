/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.dto;

import hu.elte.alkfejl.carhire.model.Rent;
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
public class RentDTO { 
    private Long id;
    private String customerName;
    private String carMake;
    private String carModel;
    private String storeName;
    private String note;
    private String employeeName;
    private String rentDate;
   
    public static RentDTO create(Rent rent) {        
        return new RentDTO(
            rent.getId(),
            rent.getCustomer().getName(),
            rent.getCar().getMake(),
            rent.getCar().getModel(),
            //Üzlet neve:
            rent.getCar().getStore().getName(),
            rent.getNote(),
            //Alkalmazott neve:
            //rent.getCar().getStore().getEmployees().get( (int)rent.getCar().getStore().getId() ).getName(),
            "TEST",
            rent.getRentDate()
        );
    }  
}
