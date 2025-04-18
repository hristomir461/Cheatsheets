package com.example.springdataexample.OneToOne;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    @OneToOne
    private Passport passport;
}
