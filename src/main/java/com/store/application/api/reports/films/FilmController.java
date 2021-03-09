package com.store.application.api.reports.films;

import com.store.application.api.ApiResponse;
import com.store.domain.film.Film;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = { "v1/film"})
@Tag(name = "film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/actor/firstName/{firstName}/lastName/{lastName}")
    public ApiResponse byActor(@PathVariable("firstName")String firstName,
                               @PathVariable("lastName")String lastName,
                               @RequestParam("category") Optional<String> category){

        List<Film> films = filmService.searchByActor(firstName,lastName);

        if(category.isPresent())
            films = films.stream().filter(f -> f.getCategory().equals(category.get())).collect(Collectors.toList());

        return new ApiFilmResponse(films);
    }
}
