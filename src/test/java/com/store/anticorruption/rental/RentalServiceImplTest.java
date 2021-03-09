package com.store.anticorruption.rental;

import com.store.anticorruption.rental.convert.OverdueRentalConverter;
import com.store.application.api.reports.rental.OverdueRentalReport;
import com.store.application.fixture.OverdueRentalFixture;
import com.store.domain.rental.Rental;
import com.store.domain.rental.fixture.RentalFixture;
import com.store.infrastructure.rental.RentalDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class RentalServiceImplTest {

    @InjectMocks
    private RentalServiceImpl serviceImpl;

    @Mock
    private RentalDao rentalDao;

    @Mock
    private OverdueRentalConverter overdueRentalConverter;

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void shouldSerchByRentalsWithOverdueDurationAndTranslateToOverdueRentalReport(){
        List<Rental> rentals = RentalFixture.get().buildAsListOf(2);
        List<OverdueRentalReport> overdueRentalReports = OverdueRentalFixture.get().buildAsListOf(2);
        given(rentalDao.overdueRentalsByDate()).willReturn(rentals);
        given(overdueRentalConverter.from(rentals)).willReturn(overdueRentalReports);
        List<OverdueRentalReport> overdueRentalReportList = serviceImpl.overdueRentals();
        assertEquals(2, overdueRentalReportList.size());
    }

}