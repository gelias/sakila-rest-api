package com.store.infrastructure.rental;

import com.store.domain.rental.Rental;
import com.store.domain.rental.fixture.RentalFixture;
import com.store.infrastructure.ConnectionManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class RentalRepositoryTest {

    @InjectMocks
    private RentalRepository rentalRepositorio;

    @Mock
    private ConnectionManager connectionManager;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void shouldQueryAndRetrieveRentalBasedOnOverdueRentalDuration(){
        List<Rental> expectedOverdueRentals = RentalFixture.get().buildAsListOf(0);
        given(connectionManager.getConnection()).willReturn(jdbcTemplate);
        given(jdbcTemplate.query(anyString(),any(RowMapper.class),any(Object[].class))).willReturn(expectedOverdueRentals);
        List<Rental> rentals = rentalRepositorio.overdueRentalsByDate();
        Assert.assertEquals(0,rentals.size());
    }
}