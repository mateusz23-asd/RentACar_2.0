package com.example.RentACar.service;
import com.example.RentACar.entity.DateRange;
public interface DateRangeService {
    DateRange getLastDateRange();
    DateRange saveDate(DateRange dateRange);
}
