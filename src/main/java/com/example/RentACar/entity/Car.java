package com.example.RentACar.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String carType;
    private int price;
    private boolean isRented;
    public Car() {
    }
    public Car( String carType, int price) {
        this.carType = carType;
        this.price = price;
    }
}
