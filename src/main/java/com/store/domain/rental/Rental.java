package com.store.domain.rental;

import static java.lang.String.format;

public class Rental {
    private final String customer;
    private final String phone;
    private final String title;

    public Rental(String customer, String phone, String title) {
        this.customer = customer;
        this.phone = phone;
        this.title = title;
    }

    public String getCustomer() {
        return customer;
    }

    public String getPhone() {
        return phone;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return format("%s_%s_%s",customer,phone,title);
    }
}
