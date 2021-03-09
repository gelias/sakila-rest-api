package com.store.application.api.reports.rental;

import com.store.application.fixture.OverdueRentalFixture;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class RentalControllerTest {

    public static final int OVERDUE_RENTAL_ELEMENTS = 2;
    @InjectMocks
    private RentalController controller;

    @Mock
    private RentalService service;

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void shouldDiscoveryAllOverdueRentals(){
        List<OverdueRentalReport> overdueRentalReportList = OverdueRentalFixture.get().buildAsListOf(OVERDUE_RENTAL_ELEMENTS);
        given(service.overdueRentals()).willReturn(overdueRentalReportList);
        APIRentalResponse overdueRentalReponse = controller.overdueRentals();
        Assert.assertEquals(OVERDUE_RENTAL_ELEMENTS,overdueRentalReponse.getContent().size());
    }

}