package com.example.RentACar.controller;

import com.example.RentACar.entity.DateRange;
import com.example.RentACar.dto.HireCarRequest;
import com.example.RentACar.entity.Car;
import com.example.RentACar.entity.Rental;
import com.example.RentACar.entity.User;
import com.example.RentACar.service.CarService;
import com.example.RentACar.service.DateRangeService;
import com.example.RentACar.service.RentalService;
import com.example.RentACar.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    @Autowired
    private RentalService rentalService;
    @Autowired
    private DateRangeService dateRangeService;

    @GetMapping("/cars/hire/{id}")
    public String createUser(@PathVariable Long id, Model model, HttpSession session){
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        User user = new User();
        model.addAttribute("user", user);
        return "hire";
    }
    @PostMapping("/cars/hire")
    public String saveUser(@ModelAttribute("hireCarRequest") HireCarRequest hireCarRequest){
        User user = new User();
        Rental rental = new Rental();
        Car car = carService.getCarById(hireCarRequest.getCarId());
        DateRange dateRange = dateRangeService.getLastDateRange();
        user.setName(hireCarRequest.getUserName());
        user.setEmail(hireCarRequest.getEmail());
        user.setPhone(hireCarRequest.getPhone());
        user.setAddress(hireCarRequest.getAddress());
        user.setNumberOfDays(hireCarRequest.getNumberOfDays());
        user.setSumOfPrice(calculatePrice(dateRange, car));
        userService.saveUser(user);
        carService.saveCars(car);
        rental.setUser(user);
        rental.setCar(car);
        rental.setDateFrom(dateRange.getDateFrom());
        rental.setDateTo(dateRange.getDateTo());
        rentalService.saveRental(rental);
        return "redirect:/cars";
    }

    private int calculatePrice(DateRange dateRange, Car car){
        int days = (dateRange.getDateTo().compareTo(dateRange.getDateFrom()))+1;
        int price = car.getPrice()* days;
        return price;
    }
}
