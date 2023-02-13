package com.example.RentACar.repository;
import com.example.RentACar.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    @Query(value = "SELECT * FROM Rental r WHERE (r.date_from BETWEEN :start AND :end) OR (r.date_to BETWEEN :start AND :end)", nativeQuery = true)
    List<Rental> findAllReservedByDateRange(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
