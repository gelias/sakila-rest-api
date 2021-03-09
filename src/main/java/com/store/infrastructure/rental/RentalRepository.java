package com.store.infrastructure.rental;

import com.store.domain.rental.Rental;
import com.store.infrastructure.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalRepository implements RentalDao {

    @Autowired
    private ConnectionManager connectionManager;

    @Override
    public List<Rental> overdueRentalsByDate() {
        return connectionManager.getConnection().query(RentalMappedQuery.RENTAL_OVERDUE.getRawValue()
                ,(rs, rowNum) -> new Rental(
                        rs.getString("customer"),
                        rs.getString("phone"),
                        rs.getString("title")
                ));
    }
}
