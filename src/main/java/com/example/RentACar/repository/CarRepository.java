package com.example.RentACar.repository;
import com.example.RentACar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByIsRentedTrue();
}
