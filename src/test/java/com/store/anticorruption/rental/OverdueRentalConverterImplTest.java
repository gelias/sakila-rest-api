package com.store.anticorruption.rental;

import com.store.anticorruption.rental.convert.OverdueRentalConverterImpl;
import com.store.application.api.reports.rental.OverdueRentalReport;
import com.store.domain.rental.Rental;
import com.store.domain.rental.fixture.RentalFixture;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class OverdueRentalConverterImplTest {

    @InjectMocks
    private OverdueRentalConverterImpl overdueRentalConverter;

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void shouldTranslateFromRentalsToOverdueRentals(){
        List<Rental> rentals = RentalFixture.get().buildAsListOf(2);
        List<OverdueRentalReport> overdueRentalReports = overdueRentalConverter.from(rentals);
        assertEquals(2, overdueRentalReports.size());
        asserEqualRentals(rentals, overdueRentalReports);
    }

    private void asserEqualRentals(List<Rental> rentals, List<OverdueRentalReport> overdueRentalReports) {
        for (Rental rental: rentals) {
            for (OverdueRentalReport overdueRentalReport : overdueRentalReports) {
                rental.toString().equals(overdueRentalReport.toString());
            }
        }
    }
}