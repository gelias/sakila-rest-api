package com.store.anticorruption.rental.convert;

import com.store.application.api.reports.rental.OverdueRentalReport;
import com.store.domain.rental.Rental;

import java.util.List;

public interface OverdueRentalConverter {
    List<OverdueRentalReport> from(List<Rental> rentals);
}
