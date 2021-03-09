package com.store.infrastructure.film;

import com.store.domain.film.Film;

import java.util.List;

public interface FilmReportDao {
    List<Film> searchByActor(String firstName, String lastName);
}
