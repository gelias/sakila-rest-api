package com.store.application.api.reports.rental;

import com.store.application.api.reports.customer.ApiContentResponse;

import java.util.List;

public class APIRentalResponse extends ApiContentResponse {

    public APIRentalResponse(List<OverdueRentalReport> overdueRentalReports) {
        super(overdueRentalReports);
    }
}
