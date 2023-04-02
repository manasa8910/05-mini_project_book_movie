package com.kitty.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity(name = "screen")
@Table(name = "screen")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "screen_name")
    private String screenName;

    private boolean active;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "fk_business_id")
    private Business businessId;

    public Screen(){}

    public Screen(String screenName) {
        this.screenName = screenName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", screenName='" + screenName + '\'' +
                ", active=" + active +
                ", businessId=" + businessId +
                '}';
    }
}
