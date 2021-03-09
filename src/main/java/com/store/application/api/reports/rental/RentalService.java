package com.store.application.api.reports.rental;

import java.util.List;

public interface RentalService {
    List<OverdueRentalReport> overdueRentals();
}
