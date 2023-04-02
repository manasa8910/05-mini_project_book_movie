package com.kitty.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "seat")
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_screen_id")
    private Screen screenId;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "seat_bookings",
            joinColumns = @JoinColumn(name = "fk_seat_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_booking_id"))
    private List<Booking> bookings;

    public Seat() {
    }

    public Seat(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Screen getScreenId() {
        return screenId;
    }

    public void setScreenId(Screen screenId) {
        this.screenId = screenId;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", screenId=" + screenId +
                '}';
    }
}
