package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.dto.CarDTO;
import hu.elte.alkfejl.carhire.model.Car;
import hu.elte.alkfejl.carhire.repository.CarRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    /*
        Új autó hozzáadása a rendszerhez:
    */
    public void addCar(Car car) {
        carRepository.save(car);
    }
    /*
        Autó törlése a rendszerből:
    */
    public void removeCar(Car car) {
        carRepository.delete(car);
    }
    /*
        Minden autó kilistázása:
    */
    public Iterable<CarDTO> listAll() {
        return convertToDTOs( carRepository.findAll() );
    }
  
    /*
        Minden autó márka:
    */
    public Iterable<String> listMakes() {
        ArrayList<String> makes = new ArrayList<String>();
        
        Iterable<Car> cars = carRepository.findAll();
        
        for (Car c : cars) {
            if (!makes.contains(c.getMake()))
                makes.add(c.getMake());
        }
        return makes;
    }
    
    /*
        Márkához tartozó típus kilistázása:
    */
    public Iterable<String> listModelsByMake(String make) {
        ArrayList<String> models = new ArrayList<String>();
        
        Iterable<Car> cars = carRepository.findAll();
        
        for (Car c : cars) {
            if (c.getMake().equals(make) && !models.contains(c.getModel()))
                models.add(c.getModel());
        }
        return models;
    }
    
    /*
        Összes típus kilistázása:
    */
    public Iterable<String> listModels() {
        ArrayList<String> models = new ArrayList<String>();
        
        Iterable<Car> cars = carRepository.findAll();
        
        for (Car c : cars) {
            if (!models.contains(c.getModel()))
                models.add(c.getModel());
        }
        return models;
    }
    
    /*
        Adatok feldolgozhatóvá konvertálása:
    */
    public Iterable<CarDTO> convertToDTOs(Iterable<Car> cars) {
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car c : cars) {
            carDTOs.add( CarDTO.create(c) );
        }
        return  carDTOs;
    }
}