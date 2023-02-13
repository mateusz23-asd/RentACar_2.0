package com.example.RentACar.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private int numberOfDays;
    private int sumOfPrice;
    public User() {
    }
    public User(String name, String email, String address, String phone, int numberOfDays, int sumOfPrice) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.numberOfDays = numberOfDays;
        this.sumOfPrice = sumOfPrice;
    }
}
