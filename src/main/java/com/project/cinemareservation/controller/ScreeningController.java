package com.project.cinemareservation.controller;

import com.project.cinemareservation.model.Screening;
import com.project.cinemareservation.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ScreeningController {
    private final ScreeningRepository screeningRepository;

    public ScreeningController(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @RequestMapping(value = "/screenings", method = RequestMethod.GET)
    public ResponseEntity<Object> getScreenings() {
        return new ResponseEntity<>(screeningRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/screenings/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getScreenings(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(screeningRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/screenings", method = RequestMethod.POST)
    public ResponseEntity<Object> createScreening(@RequestBody Screening screening) {
        return new ResponseEntity<>(screeningRepository.save(screening), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/screenings/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateScreening(@PathVariable("id") Integer id, @RequestBody Screening newScreening) {
        Screening result = screeningRepository.findById(id).map(screening -> {
            screening.setTime(newScreening.getTime());
            screening.setMovie(newScreening.getMovie());
            screening.setHall(newScreening.getHall());
            return screeningRepository.save(screening);
        }).orElseGet(() -> {
            newScreening.setId(id);
            return screeningRepository.save(newScreening);
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/screenings/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteScreening(@PathVariable("id") Integer id) {
        Optional<Screening> toDelete = screeningRepository.findById(id);
        if (toDelete.isPresent()) {
            screeningRepository.delete(toDelete.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
