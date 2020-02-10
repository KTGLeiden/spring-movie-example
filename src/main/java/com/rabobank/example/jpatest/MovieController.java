package com.rabobank.example.jpatest;

import com.rabobank.example.jpatest.models.Movie;
import com.rabobank.example.jpatest.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> index() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        return optionalMovie.orElse(null);
    }

    @PostMapping
    public String addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return "Movie has been added";
    }
}
