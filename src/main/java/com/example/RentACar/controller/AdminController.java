package com.example.RentACar.controller;
import com.example.RentACar.entity.Car;
import com.example.RentACar.entity.Rental;
import com.example.RentACar.service.CarService;
import com.example.RentACar.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AdminController {
    @Autowired
    CarService carService;
    @Autowired
    RentalService rentalService;

    @GetMapping("/admin")
    public String listCars(Model model){
        List<Car> cars = carService.getAllCars();
        List<Rental> rentals = rentalService.getAllRent();
        model.addAttribute("cars", cars);
        model.addAttribute("rentals", rentals);
        return "admin";
    }
    @GetMapping("/cars/new")
    public String createNewCar(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";
    }
    @PostMapping("/cars")
    public String saveCar(@ModelAttribute("car") Car car){
        Car activatedCar = car;
        activatedCar.setRented(true);
        carService.saveCars(activatedCar);
        return "redirect:/admin";
    }
    @GetMapping("/cars/edit/{id}")
    public String editCar(@PathVariable Long id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "edit_car";
    }
    @PostMapping("/cars/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute("car") Car car){
        Car existingCar = carService.getCarById(id);
        existingCar.setId(id);
        existingCar.setCarType(car.getCarType());
        existingCar.setPrice(car.getPrice());
        carService.saveCars(existingCar);
        return "redirect:/admin";
    }
    @GetMapping("/cars/reset/{id}")
    public String resetRentStatus(@PathVariable Long id){
        Car car = carService.getCarById(id);
        if(car.isRented()==false){
            car.setRented(true);
        } else {
            car.setRented(false);
        }
        carService.saveCars(car);
        return "redirect:/admin";
    }
    @GetMapping("/cars/delete/{id}")
    public String deleteRent(@PathVariable Long id){
        rentalService.deleteRentById(id);
        return "redirect:/admin";
    }
}
