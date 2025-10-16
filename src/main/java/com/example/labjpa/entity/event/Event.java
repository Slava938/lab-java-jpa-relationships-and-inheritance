package com.example.labjpa.entity.event;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate date;
    private Integer duration;
    private String location;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="event_guest",
        joinColumns=@JoinColumn(name="event_id"),
        inverseJoinColumns=@JoinColumn(name="guest_id"))
    private Set<Guest> guests = new HashSet<>();
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public LocalDate getDate(){return date;}
    public void setDate(LocalDate date){this.date=date;}
    public Integer getDuration(){return duration;}
    public void setDuration(Integer duration){this.duration=duration;}
    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}
    public Set<Guest> getGuests(){return guests;}
    public void setGuests(Set<Guest> guests){this.guests=guests;}
}
