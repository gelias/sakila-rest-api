package com.store.anticorruption.film;

import com.store.infrastructure.film.FilmReportDao;
import com.store.domain.film.Film;
import com.store.infrastructure.film.FilmReportFixture;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

public class FilmServiceImplTest {

    @InjectMocks
    private FilmServiceImpl filmService;

    @Mock
    private FilmReportDao filmDao;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSearchFilmsByActor(){
        given(filmDao.searchByActor(anyString(), anyString())).willReturn(FilmReportFixture.get().buildAsListOf(2));
        List<Film> films = filmService.searchByActor("Tom","Cruise");
        Assert.assertEquals(2,films.size());

    }
}