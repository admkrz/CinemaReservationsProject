package com.project.cinemareservation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;

    @OneToMany(mappedBy="reservation", cascade = CascadeType.ALL)
    private List<ReservedSeat> reservedSeats = new ArrayList<>();

    public Reservation(String name, String surname, String email, ReservationStatus status, Screening screening) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.status = status;
        this.screening = screening;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", screening=" + screening +
                ", reservedSeats=" + reservedSeats +
                '}';
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public List<ReservedSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
