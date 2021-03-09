package com.store.application.api.reports.customer;

import com.store.application.api.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "v1/customer"})
@Tag(name = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/country/{country}")
    public ApiResponse byCountry(@PathVariable("country")String country) {
        var totalCustomers = customerService.totalCustomerByCountry(country);
        return new ApiContentResponse(totalCustomers);
    }

    @GetMapping("/country/{country}/city/{city}")
    public ApiResponse byCountryAndCity(@PathVariable("country")String country, @PathVariable("city")String city) {
        var totalCustomers = customerService.totalCustomerByCountryAndCity(country,city);
        return new ApiContentResponse(totalCustomers);
    }
}
