package com.example.springdataexample.OneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String language;
    @OneToMany(mappedBy = "country")
    public List<City> cities;
}
