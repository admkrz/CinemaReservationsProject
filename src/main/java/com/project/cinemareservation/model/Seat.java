package com.project.cinemareservation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer rowIndex;
    private Integer seatIndex;
    private Integer price;
    private SeatStatus status;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    @JsonIgnoreProperties("seats")
    private Hall hall;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("seat")
    private List<ReservedSeat> reservedSeats = new ArrayList<>();

    public Seat(){}

    public Seat(Integer rowIndex, Integer seatIndex, Integer price, SeatStatus status) {
        this.rowIndex = rowIndex;
        this.seatIndex = seatIndex;
        this.price = price;
        this.status = status;
    }

    public Seat(Integer rowIndex, Integer seatIndex, Integer price, SeatStatus status, Hall hall) {
        this.rowIndex = rowIndex;
        this.seatIndex = seatIndex;
        this.price = price;
        this.status = status;
        this.hall = hall;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getSeatIndex() {
        return seatIndex;
    }

    public void setSeatIndex(Integer seatIndex) {
        this.seatIndex = seatIndex;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public List<ReservedSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", rowIndex=" + rowIndex +
                ", seatIndex=" + seatIndex +
                ", price=" + price +
                ", status=" + status +
                ", hall=" + hall +
                ", reservedSeats=" + reservedSeats +
                '}';
    }
}
