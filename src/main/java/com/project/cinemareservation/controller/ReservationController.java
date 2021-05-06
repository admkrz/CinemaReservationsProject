package com.project.cinemareservation.controller;

import com.project.cinemareservation.model.Reservation;
import com.project.cinemareservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReservationController {
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public ResponseEntity<Object> getReservations() {
        return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getReservations(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(reservationRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationRepository.save(reservation), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateReservation(@PathVariable("id") Integer id, @RequestBody Reservation newReservation) {
        Reservation result = reservationRepository.findById(id).map(reservation -> {
            reservation.setName(newReservation.getName());
            reservation.setSurname(newReservation.getSurname());
            reservation.setEmail(newReservation.getEmail());
            reservation.setStatus(newReservation.getStatus());
            reservation.setScreening(newReservation.getScreening());
            return reservationRepository.save(reservation);
        }).orElseGet(() -> {
            newReservation.setId(id);
            return reservationRepository.save(newReservation);
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteReservation(@PathVariable("id") Integer id) {
        Optional<Reservation> toDelete = reservationRepository.findById(id);
        if (toDelete.isPresent()) {
            reservationRepository.delete(toDelete.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
