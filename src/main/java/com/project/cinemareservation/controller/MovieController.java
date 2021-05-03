package com.project.cinemareservation.controller;

import com.project.cinemareservation.model.Movie;
import com.project.cinemareservation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<Object> getMovies() {
        return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getMovies(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(movieRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<Object> createMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieRepository.save(movie), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateMovie(@PathVariable("id") Integer id, @RequestBody Movie newMovie) {
        Movie result = movieRepository.findById(id).map(movie -> {
            movie.setDuration(newMovie.getDuration());
            movie.setTitle(newMovie.getTitle());
            movie.setTmdbId(newMovie.getTmdbId());
            movie.setScreenings(newMovie.getScreenings());
            return movieRepository.save(movie);
        }).orElseGet(() -> {
            newMovie.setId(id);
            return movieRepository.save(newMovie);
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMovie(@PathVariable("id") Integer id) {
        Optional<Movie> toDelete = movieRepository.findById(id);
        if (toDelete.isPresent()) {
            movieRepository.delete(toDelete.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
