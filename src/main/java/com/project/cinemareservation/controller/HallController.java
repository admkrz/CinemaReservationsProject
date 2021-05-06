package com.project.cinemareservation.controller;

import com.project.cinemareservation.model.Hall;
import com.project.cinemareservation.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HallController {
    @Autowired
    private HallRepository hallRepository;

    @RequestMapping(value = "/halls", method = RequestMethod.GET)
    public ResponseEntity<Object> getHalls() {
        return new ResponseEntity<>(hallRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/halls/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getHalls(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(hallRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/halls", method = RequestMethod.POST)
    public ResponseEntity<Object> createHall(@RequestBody Hall hall) {
        return new ResponseEntity<>(hallRepository.save(hall), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/halls/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateHall(@PathVariable("id") Integer id, @RequestBody Hall newHall) {
        Hall result = hallRepository.findById(id).map(hall -> {
            hall.setName(newHall.getName());
            hall.setRowCount(newHall.getRowCount());
            hall.setColumnCount(newHall.getColumnCount());
            hall.setScreenings(newHall.getScreenings());
            hall.setSeats(newHall.getSeats());
            return hallRepository.save(hall);
        }).orElseGet(() -> {
            newHall.setId(id);
            return hallRepository.save(newHall);
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/halls/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHall(@PathVariable("id") Integer id) {
        Optional<Hall> toDelete = hallRepository.findById(id);
        if (toDelete.isPresent()) {
            hallRepository.delete(toDelete.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
