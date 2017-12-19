/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.dto;

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
public class StoreDTO {    
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    
    public static StoreDTO create(Store store) {
        return new StoreDTO(
            store.getId(),
            store.getName(),
            store.getAddress(),
            store.getPhoneNumber()
        );
    }    
}
