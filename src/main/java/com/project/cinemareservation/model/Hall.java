package com.project.cinemareservation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer rowCount;
    private Integer columnCount;

    @OneToMany(mappedBy="hall", cascade = CascadeType.ALL)
    private List<Screening> screenings = new ArrayList<>();

    @OneToMany(mappedBy="hall", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    public Hall(String name, Integer rowCount, Integer columnCount) {
        this.name = name;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
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

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rowCount=" + rowCount +
                ", columnCount=" + columnCount +
                ", screenings=" + screenings +
                ", seats=" + seats +
                '}';
    }
}
