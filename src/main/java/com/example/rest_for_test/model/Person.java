package com.example.rest_for_test.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "surname", length = 50)
    private String surname;
    @Column(name = "age", length = 3)
    private Integer age;
}
