package com.store.infrastructure.film;

import com.store.domain.film.Film;
import com.store.infrastructure.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmRepository implements FilmReportDao {

    @Autowired
    private ConnectionManager connectionManager;

    @Override
    public List<Film> searchByActor(String firstName, String lastName) {
        Object[] inputs = new Object[]{firstName.toLowerCase(), lastName.toLowerCase()};
        return connectionManager.getConnection().query(FilmMappedQuery.FILM_BY_ACTOR.getRawValue()
                ,(rs, rowNum) -> new Film(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("category")
                ),inputs);
    }
}
