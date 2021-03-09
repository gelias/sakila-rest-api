package com.store.application.api.reports.films;

import com.store.domain.film.Film;

import java.util.List;

public interface FilmService {
    List<Film> searchByActor(String firstName, String lastName);
}
