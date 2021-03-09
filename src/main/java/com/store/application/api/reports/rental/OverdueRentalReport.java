package com.store.application.api.reports.rental;

import com.store.application.api.ApiEntity;
import com.store.domain.rental.Rental;
import lombok.Getter;

import static java.lang.String.format;

public class OverdueRentalReport implements ApiEntity {
    @Getter private String customer;
    @Getter private String phone;
    @Getter private String title;

    public OverdueRentalReport(String customer, String phone, String title) {
        this.customer = customer;
        this.phone = phone;
        this.title = title;
    }

    public OverdueRentalReport(Rental rental) {
        this.customer = rental.getCustomer();
        this.phone = rental.getPhone();
        this.title = rental.getTitle();
    }

    @Override
    public String toString() {
        return format("%s_%s_%s",customer,phone,title);
    }
}
