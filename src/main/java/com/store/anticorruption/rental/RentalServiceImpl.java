package com.store.anticorruption.rental;

import com.store.anticorruption.rental.convert.OverdueRentalConverter;
import com.store.application.api.reports.rental.OverdueRentalReport;
import com.store.application.api.reports.rental.RentalService;
import com.store.domain.rental.Rental;
import com.store.infrastructure.rental.RentalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalDao rentalDao;

    @Autowired
    private OverdueRentalConverter rentalOverdueConverter;

    @Override
    public List<OverdueRentalReport> overdueRentals() {
        List<Rental> rentals = rentalDao.overdueRentalsByDate();
        return rentalOverdueConverter.from(rentals);
    }
}
