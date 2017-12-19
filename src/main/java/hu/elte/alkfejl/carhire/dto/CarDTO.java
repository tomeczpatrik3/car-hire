/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carhire.dto;

import hu.elte.alkfejl.carhire.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author range
 */

/*
    Adatok konvertálása a frontend számára!
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private long id;
    private String plateNumber;
    private String make;
    private String model;
    private int year;
    private String color;
    private int doors;
    private int seats;
    private int price;
 
    public static CarDTO create(Car car) {
        return new CarDTO(
            car.getId(),
            car.getPlateNumber(),
            car.getMake(),
            car.getModel(),
            car.getYear(),
            car.getColor(),
            car.getDoors(),
            car.getSeats(),
            car.getPrice()
        );
    }
}
