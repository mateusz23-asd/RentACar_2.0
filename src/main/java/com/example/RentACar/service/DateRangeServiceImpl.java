package com.example.RentACar.service;
import com.example.RentACar.entity.DateRange;
import com.example.RentACar.repository.DateRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class DateRangeServiceImpl implements DateRangeService{
    @Autowired
    DateRangeRepository dateRangeRepository;
    @Override
    public DateRange saveDate(DateRange dateRange) {
        return dateRangeRepository.save(dateRange);
    }
    @Override
    public DateRange getLastDateRange() {
        List<DateRange> dateRangeList = dateRangeRepository.findAll();
        if (dateRangeList.size() == 0){
            DateRange lastDate = new DateRange(LocalDate.now(), LocalDate.now().plusDays(3));
            return lastDate;
        }
        DateRange lastDate = dateRangeList.get(dateRangeList.size()-1);
        return lastDate;
    }
}
