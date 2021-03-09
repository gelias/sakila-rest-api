package com.store.anticorruption.customer;

import com.store.application.api.reports.customer.CustomerService;
import com.store.infrastructure.customer.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Long totalCustomerByCountry(String country) {
        return customerDao.totalByCountry(country);
    }

    @Override
    public Long totalCustomerByCountryAndCity(String country, String city) {
        return customerDao.totalByCountryAndCity(country,city);
    }
}
