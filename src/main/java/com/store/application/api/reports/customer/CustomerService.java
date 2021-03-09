package com.store.application.api.reports.customer;

public interface CustomerService {

    Long totalCustomerByCountry(String country);

    Long totalCustomerByCountryAndCity(String country, String city);
}
