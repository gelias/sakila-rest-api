package com.store.application.api.reports.rental;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = { "v1/rental"})
@Tag(name = "rental")
public class RentalController {

    @Autowired
    private RentalService service;

    @GetMapping("/overdue")
    public APIRentalResponse overdueRentals(){
        List<OverdueRentalReport> overdueRentalReportList = service.overdueRentals();
        return new APIRentalResponse(overdueRentalReportList);
    }
}
