package com.example.labjpa.entity.contact;

import jakarta.persistence.*;

@Entity
public class Contact {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String title;
    @Embedded
    private Name name;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getCompany(){return company;}
    public void setCompany(String company){this.company=company;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public Name getName(){return name;}
    public void setName(Name name){this.name=name;}
}
