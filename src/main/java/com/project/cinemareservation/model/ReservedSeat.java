package com.project.cinemareservation.model;

import javax.persistence.*;

@Entity
@Table(name = "reserved_seats")
public class ReservedSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="reservation_id", nullable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name="seats_id", nullable = false)
    private Seat seat;

    public ReservedSeat(Reservation reservation, Seat seat) {
        this.reservation = reservation;
        this.seat = seat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "ReservedSeat{" +
                "id=" + id +
                ", reservation=" + reservation +
                ", seat=" + seat +
                '}';
    }
}
