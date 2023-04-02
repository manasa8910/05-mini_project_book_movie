package com.kitty.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity(name = "movie")
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movie_name")
    private String movieName;

    private String producer;

    private String director;

    @Column(name = "lead_actor")
    private String leadActor;

    @Column(name = "lead_actress")
    private String leadActress;

    private String description;

    @Column(name = "duration_in_mins")
    private Integer durationInMins;

    private Boolean active;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "fk_language_id")
    private Language languageId;

    public Movie() {
    }

    public Movie(String movieName, String producer, String director, String leadActor, String leadActress, String description, Integer durationInMins) {
        this.movieName = movieName;
        this.producer = producer;
        this.director = director;
        this.leadActor = leadActor;
        this.leadActress = leadActress;
        this.description = description;
        this.durationInMins = durationInMins;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getLeadActress() {
        return leadActress;
    }

    public void setLeadActress(String leadActress) {
        this.leadActress = leadActress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationInMins() {
        return durationInMins;
    }

    public void setDurationInMins(Integer durationInMins) {
        this.durationInMins = durationInMins;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", producer='" + producer + '\'' +
                ", director='" + director + '\'' +
                ", leadActor='" + leadActor + '\'' +
                ", leadActress='" + leadActress + '\'' +
                ", description='" + description + '\'' +
                ", durationInMins=" + durationInMins +
                ", active=" + active +
                ", languageId=" + languageId +
                '}';
    }
}
