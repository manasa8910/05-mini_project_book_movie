package com.kitty.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity(name = "business")
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "fk_owner_id")
    private User ownerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @Column(name = "theater_name")
    private String theaterName;

    @Column(name = "active")
    private boolean isActive;

    public Business() {}

    public Business(User ownerId, Address address, String theaterName) {
        this.theaterName = theaterName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", addressId=" + address +
                ", theaterName='" + theaterName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
