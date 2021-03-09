package com.store.anticorruption.rental.convert;

import com.store.application.api.reports.rental.OverdueRentalReport;
import com.store.domain.rental.Rental;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OverdueRentalConverterImpl implements OverdueRentalConverter {

    @Override
    public List<OverdueRentalReport> from(List<Rental> rentals) {
        ArrayList<OverdueRentalReport> overdueRentalReports = new ArrayList<>();
        for (Rental rental: rentals) {
            overdueRentalReports.add(new OverdueRentalReport(rental));
        }
        return overdueRentalReports;
    }
}
