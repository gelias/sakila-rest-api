package com.store.infrastructure.film;

import com.store.domain.film.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmReportFixture {

    private int elements;

    public static FilmReportFixture get() {
        return new FilmReportFixture();
    }

    public List<Film> buildAsListOf(int elements) {
        List<Film> films = new ArrayList<Film>();
        for (int i = 0; i < elements; i++) {
            films.add(new Film("Actor_"+i, "Last_Name"+i, "007_"+i, "The Best movie"+i, "Action"+i));
        }
        return films;
    }
}
