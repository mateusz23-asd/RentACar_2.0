package com.example.RentACar.service;
import com.example.RentACar.entity.Rental;

import java.time.LocalDate;
import java.util.List;
public interface RentalService {
    Rental saveRental(Rental rental);
    List<Rental> getCarsByDate(LocalDate dateFrom, LocalDate dateTo);
    List<Rental> getAllRent();
    void deleteRentById(Long id);
}
