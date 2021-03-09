package com.store.infrastructure.customer;

public interface CustomerDao {
    Long totalByCountry(String country);

    Long totalByCountryAndCity(String country, String city);
}
