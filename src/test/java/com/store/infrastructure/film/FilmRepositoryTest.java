package com.store.infrastructure.film;

import com.store.domain.film.Film;
import com.store.infrastructure.ConnectionManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class FilmRepositoryTest {

    public static final int EMPTY_LIST = 0;
    @InjectMocks
    private FilmRepository filmReportRepository;

    @Mock
    private ConnectionManager connectionManager;

    @Mock
    private JdbcTemplate jdbcConnection;

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void shouldSearchFilmsByActorUsingReportView(){
        List<Film> filmReports = FilmReportFixture.get().buildAsListOf(EMPTY_LIST);
        given(connectionManager.getConnection()).willReturn(jdbcConnection);
        given(jdbcConnection.query(anyString(),any(RowMapper.class),any(Object[].class))).willReturn(filmReports);
        List<Film> films = filmReportRepository.searchByActor("Tom","Cruise");
        Assert.assertEquals(EMPTY_LIST, films.size());
    }
}