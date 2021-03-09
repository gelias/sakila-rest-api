package com.store.anticorruption.customer;

import com.store.infrastructure.customer.CustomerDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class CustomerServiceImplTest {

    public static final long TOTAL_CUSTOMERS_IN_BRAZIL = 10L;
    public static final String BRAZIL_AS_COUNTRY = "Brazil";
    public static final String PORTO_ALEGRE_AS_CITY = "Porto Alegre";
    public static final long TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE = 5L;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldCountTheAmountOfCustomerBySpecificCountry(){
        given(customerDao.totalByCountry(anyString())).willReturn(TOTAL_CUSTOMERS_IN_BRAZIL);
        long totalCustomers = customerService.totalCustomerByCountry(BRAZIL_AS_COUNTRY);
        assertEquals(TOTAL_CUSTOMERS_IN_BRAZIL,totalCustomers);
    }

    @Test
    public void shouldCountTheAmountOfCustomerBySpecificCountryAndCity(){
        given(customerDao.totalByCountryAndCity(anyString(), anyString())).willReturn(TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE);
        long totalCustomers = customerService.totalCustomerByCountryAndCity(BRAZIL_AS_COUNTRY, PORTO_ALEGRE_AS_CITY);
        assertEquals(TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE,totalCustomers);
    }
}