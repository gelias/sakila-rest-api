package com.store.domain.rental.fixture;

import com.store.domain.rental.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalFixture {

    public static RentalFixture get(){
        return new RentalFixture();
    }

    public List<Rental> buildAsListOf(int elements) {
        ArrayList<Rental> rentals = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            rentals.add(new Rental("Customer_"+i,"098765432"+i,"Title_"+i));
        }
        return rentals;
    }
}
