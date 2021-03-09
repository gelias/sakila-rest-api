package com.store.application.fixture;

import com.store.application.api.reports.rental.OverdueRentalReport;

import java.util.ArrayList;
import java.util.List;

public class OverdueRentalFixture {

    public static OverdueRentalFixture get() {
        return new OverdueRentalFixture();
    }

    public List<OverdueRentalReport> buildAsListOf(int elements) {

        ArrayList<OverdueRentalReport> overdueRentalReports = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            overdueRentalReports.add(new OverdueRentalReport("Customer_"+i,"098765342"+i,"Title_"+i));
        }
        return overdueRentalReports;
    }
}
