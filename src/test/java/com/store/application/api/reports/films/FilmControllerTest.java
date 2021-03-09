package com.store.application.api.reports.films;

import com.store.infrastructure.film.FilmReportFixture;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class FilmControllerTest {

    @InjectMocks
    private FilmController filmController;

    @Mock
    private FilmService filmService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldSearchFilmByActor() {
        given(filmService.searchByActor(anyString(), anyString())).willReturn(FilmReportFixture.get().buildAsListOf(2));
        ApiFilmResponse response = (ApiFilmResponse) filmController.byActor("Tom","Cruise", Optional.empty());
        Assert.assertEquals(2, response.getContent().size());
    }
}