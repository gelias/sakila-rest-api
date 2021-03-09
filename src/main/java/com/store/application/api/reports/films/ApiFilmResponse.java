package com.store.application.api.reports.films;

import com.store.application.api.reports.customer.ApiContentResponse;
import com.store.domain.film.Film;

import java.util.List;

public class ApiFilmResponse extends ApiContentResponse {

    public ApiFilmResponse(List<Film> films) {
        super(films);
    }

}
