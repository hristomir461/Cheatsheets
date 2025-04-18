package com.example.springdataexample.OneToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String nationality;
    @OneToOne(mappedBy = "passport")
    private Person person;
}
