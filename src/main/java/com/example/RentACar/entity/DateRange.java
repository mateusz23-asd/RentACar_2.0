package com.example.RentACar.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "dateRange")
public class DateRange {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    public DateRange() {
    }
    public DateRange(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
