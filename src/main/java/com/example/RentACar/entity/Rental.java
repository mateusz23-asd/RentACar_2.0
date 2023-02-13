package com.example.RentACar.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Car car;
    @ManyToOne
    private User user;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    public Rental() {
    }
    public Rental(Car car, User user, LocalDate dateFrom, LocalDate dateTo) {
        this.car = car;
        this.user = user;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
