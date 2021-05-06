package com.project.cinemareservation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer tmdbId;
    private String title;
    private Time duration;

    @OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("movie")
    private List<Screening> screenings = new ArrayList<>();

    public Movie() {
    }

    public Movie(Integer tmdbId, String title, Time duration) {
        this.tmdbId = tmdbId;
        this.title = title;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", tmdbId=" + tmdbId +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", screenings=" + screenings +
                '}';
    }
}
