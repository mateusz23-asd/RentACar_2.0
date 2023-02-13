package com.example.RentACar.dto;
import lombok.Data;

import java.time.LocalDate;
@Data
public class HireCarRequest {
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String userName;
    private String email;
    private String address;
    private String phone;
    private int numberOfDays;
    private int sumOfPrice;
    private Long carId;
}
