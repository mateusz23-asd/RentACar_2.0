package com.example.RentACar.service;
import com.example.RentACar.entity.Rental;
import com.example.RentACar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class RentalServiceImpl implements RentalService{
    @Autowired
    private RentalRepository rentalRepository;
    @Override
    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }
    @Override
    public List<Rental> getCarsByDate(LocalDate dateFrom, LocalDate dateTo) {
        return rentalRepository.findAllReservedByDateRange(dateFrom, dateTo);
    }
    @Override
    public List<Rental> getAllRent() {
        return rentalRepository.findAll();
    }
    @Override
    public void deleteRentById(Long id) {
        rentalRepository.deleteById(id);
    }
}
