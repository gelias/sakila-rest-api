package com.store.infrastructure.customer;

import com.store.infrastructure.ConnectionManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class CustomerRepositoryTest {

    public static final long TOTAL_CUSTOMERS_IN_BRAZIL = 10L;
    public static final long TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE = 5l;
    @InjectMocks
    private CustomerRepository customerRepository;

    @Mock
    private ConnectionManager connectionManager;

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void shouldGetTotalCustomersFromBrazil() {
        given(connectionManager.queryObject(anyString(), any(Object[].class), any())).willReturn(TOTAL_CUSTOMERS_IN_BRAZIL);
        long totalCustomersFromBrazil = customerRepository.totalByCountry("Brazil");
        assertEquals(TOTAL_CUSTOMERS_IN_BRAZIL, totalCustomersFromBrazil);
    }

    @Test
    public void shouldGetTotalCustomersFromBrazilAndPortoAlegre() {
        given(connectionManager.queryObject(anyString(), any(Object[].class), any())).willReturn(TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE);
        long totalCustomersFromBrazilAndPortoAlegre = customerRepository.totalByCountryAndCity("Brazil", "Porto Alegre");
        assertEquals(TOTAL_CUSTOMERS_IN_BRAZIL_AND_PORTO_ALEGRE, totalCustomersFromBrazilAndPortoAlegre);
    }

    @Test(expected = CustomerRepositoryException.class)
    public void shouldThrowCustomerRepositoryExceptionWhenSearchingByCountryAndCityDueUnexpectedErrorInDataAccess() {
        BDDMockito.willThrow(CustomerRepositoryException.class).given(connectionManager).queryObject(anyString(), any(Object[].class), any());
        customerRepository.totalByCountryAndCity("Brazil", "Porto Alegre");
    }

    @Test(expected = CustomerRepositoryException.class)
    public void shouldThrowCustomerRepositoryExceptionWhenSearchingByCountryDueUnexpectedErrorInDataAccess() {
        BDDMockito.willThrow(CustomerRepositoryException.class).given(connectionManager).queryObject(anyString(), any(Object[].class), any());
        customerRepository.totalByCountry("Brazil");
    }

}