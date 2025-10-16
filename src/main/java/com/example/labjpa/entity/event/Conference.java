package com.example.labjpa.entity.event;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Conference extends Event {
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Speaker> speakers = new ArrayList<>();
    public List<Speaker> getSpeakers(){return speakers;}
    public void setSpeakers(List<Speaker> speakers){this.speakers=speakers;}
}
