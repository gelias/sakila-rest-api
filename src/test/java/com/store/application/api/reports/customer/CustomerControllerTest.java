package com.store.application.api.reports.customer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class CustomerControllerTest {

    public static final String BRAZIL_AS_COUNTRY = "Brazil";
    public static final Long TOTAL_CUSTOMERS_IN_BRAZIL = 10L;
    public static final String PORTO_ALEGRE_AS_CITY = "Porto Alegre";
    public static final Long TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE = 5L;
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldCountAllCustomersFromBrazilAsCountry(){
        given(customerService.totalCustomerByCountry(anyString())).willReturn(TOTAL_CUSTOMERS_IN_BRAZIL);
        ApiContentResponse totalCustomers = (ApiContentResponse) customerController.byCountry(BRAZIL_AS_COUNTRY);
        assertEquals(TOTAL_CUSTOMERS_IN_BRAZIL, totalCustomers.getRecords());
    }

    @Test
    public void shouldCountAllCustomersFromBrazilAsCountryAndPortoAlegreAsCity(){
        given(customerService.totalCustomerByCountryAndCity(anyString(),anyString())).willReturn(TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE);
        ApiContentResponse totalCustomers = (ApiContentResponse)customerController.byCountryAndCity(BRAZIL_AS_COUNTRY, PORTO_ALEGRE_AS_CITY);
        assertEquals(TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE, totalCustomers.getRecords());
    }
}