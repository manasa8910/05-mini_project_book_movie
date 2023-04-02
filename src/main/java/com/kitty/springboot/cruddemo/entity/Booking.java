package com.kitty.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "booking")
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "fk_user_id")
    private  User userId;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "fk_show_id")
    private Show showId;

    @Column(name = "payment_amount")
    private Double paymentAmount;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "seat_bookings",
            joinColumns = @JoinColumn(name = "fk_booking_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_seat_id"))
    private List<Seat> Seats;

    public Booking() {
    }

    public Booking(Integer numberOfSeats, Double paymentAmount) {
        this.numberOfSeats = numberOfSeats;
        this.paymentAmount = paymentAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Show getShowId() {
        return showId;
    }

    public void setShowId(Show showId) {
        this.showId = showId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
                ", userId=" + userId +
                ", showId=" + showId +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
