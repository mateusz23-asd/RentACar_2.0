package com.example.RentACar.service;
import com.example.RentACar.entity.Car;
import java.util.List;
public interface CarService {
    List<Car> getAllCars();
    Car saveCars(Car car);
    Car getCarById(Long id);
    void deleteCar(Long id);
    List<Car> getFreeCars();
}
