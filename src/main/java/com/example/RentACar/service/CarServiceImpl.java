package com.example.RentACar.service;
import com.example.RentACar.entity.Car;
import com.example.RentACar.repository.CarRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    @Override
    public Car saveCars(Car car) {
        return carRepository.save(car);
    }
    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }
    @Override
    public void deleteCar(Long id) {
       carRepository.deleteById(id);
    }
   @Override
    public List<Car> getFreeCars() {
        return carRepository.findAllByIsRentedTrue();
    }
}
