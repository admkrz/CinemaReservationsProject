package com.project.cinemareservation.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Time time;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="hall_id", nullable = false)
    private Hall hall;

    public Screening(Time time, Movie movie, Hall hall) {
        this.time = time;
        this.movie = movie;
        this.hall = hall;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", time=" + time +
                ", movie=" + movie +
                ", hall=" + hall +
                '}';
    }
}
