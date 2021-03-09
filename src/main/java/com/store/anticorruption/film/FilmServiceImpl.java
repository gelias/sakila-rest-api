package com.store.anticorruption.film;

import com.store.application.api.reports.films.FilmService;
import com.store.domain.film.Film;
import com.store.infrastructure.film.FilmReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmReportDao filmReportDao;

    @Override
    public List<Film> searchByActor(String firstName, String lastName) {
        return filmReportDao.searchByActor(firstName, lastName);
    }
}
