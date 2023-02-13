package com.example.RentACar.repository;
import com.example.RentACar.entity.DateRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DateRangeRepository extends JpaRepository<DateRange, Long> {
}
