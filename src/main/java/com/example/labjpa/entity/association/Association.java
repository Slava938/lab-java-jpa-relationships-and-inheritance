package com.example.labjpa.entity.association;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Association {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Division> divisions = new ArrayList<>();

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public List<Division> getDivisions(){return divisions;}
    public void setDivisions(List<Division> divisions){this.divisions=divisions;}
}
