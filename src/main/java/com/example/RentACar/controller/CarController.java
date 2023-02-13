package com.example.RentACar.controller;
import com.example.RentACar.entity.DateRange;
import com.example.RentACar.entity.Rental;
import com.example.RentACar.service.CarService;
import com.example.RentACar.entity.Car;
import com.example.RentACar.service.DateRangeService;
import com.example.RentACar.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private DateRangeService dateRangeService;
    @Autowired
    private RentalService rentalService;
    @GetMapping("/cars")
    public String listCars(Model model){
        List<Car> cars = carService.getFreeCars();
        DateRange pickedRange = dateRangeService.getLastDateRange();
        List<Rental> reservedRentals = rentalService.getCarsByDate(pickedRange.getDateFrom(), pickedRange.getDateTo());
        for (Rental rental : reservedRentals) {
            for (int i = 0; i < cars.size(); i++) {
               if(rental.getCar().getId() == cars.get(i).getId()) {
                   cars.remove(i);
               }
            }
        }
        model.addAttribute("pickedRange", pickedRange);
        model.addAttribute("cars", cars);
        DateRange dateRange = new DateRange();
        model.addAttribute("dateRange", dateRange);
        return "cars";
    }
    @PostMapping("/cars/date/pick")
    public String setDateRange(@ModelAttribute("dateRange") DateRange dateRange){
        DateRange datePresent = new DateRange();
        datePresent.setDateFrom(LocalDate.now());
        datePresent.setDateTo(LocalDate.now().plusDays(3));
        if(LocalDate.now().isAfter(dateRange.getDateFrom()) ){
            dateRangeService.saveDate(datePresent);
        }else{
            dateRangeService.saveDate(dateRange);
        }
        return "redirect:/cars";
    }
}
