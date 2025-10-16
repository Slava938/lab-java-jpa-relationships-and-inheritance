package com.example.labjpa.entity.event;
import jakarta.persistence.*;
@Entity
public class Guest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private GuestStatus status;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public GuestStatus getStatus(){return status;}
    public void setStatus(GuestStatus status){this.status=status;}
}
