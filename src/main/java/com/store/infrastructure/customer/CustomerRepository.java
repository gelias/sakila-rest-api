package com.store.infrastructure.customer;

import com.store.infrastructure.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static java.lang.String.format;

@Repository
public class CustomerRepository implements CustomerDao {

    @Autowired
    private ConnectionManager connectionManager;

    @Override
    public Long totalByCountry(String country) {
        try {
            Object[] filter = new Object[] { country.toLowerCase() };
            //TODO
            Long totalCustomers = (Long) connectionManager.queryObject(CustomerMappedQuery.CUSTOMER_BY_COUNTRY.getRawValue(),filter,Long.class);
            return totalCustomers;
            // TODO
        } catch (Throwable exception){
            exception.printStackTrace();
            throw new CustomerRepositoryException(format("It was not possible calculate total customer by country. Country %s",country));
        }

    }

    @Override
    public Long totalByCountryAndCity(String country, String city) {
        try {
            Object[] filter = new Object[] { country.toLowerCase(), city.toLowerCase() };
            //TODO
            Long totalCustomers = (Long) connectionManager.queryObject(CustomerMappedQuery.CUSTOMER_BY_COUNTRY_AND_CITY.getRawValue(),filter,Long.class);
            return totalCustomers;
        } catch (Throwable exception){
            exception.printStackTrace();
            //TODO
            throw new CustomerRepositoryException(format("It was not possible calculate total customer by country ad city. Country %s / City %s",country, city));
        }

    }
}
