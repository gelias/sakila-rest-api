package com.store.infrastructure.rental;

import com.store.domain.rental.Rental;

import java.util.List;

public interface RentalDao {
    List<Rental> overdueRentalsByDate();
}
