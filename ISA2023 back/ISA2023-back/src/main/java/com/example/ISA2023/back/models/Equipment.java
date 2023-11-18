package com.example.ISA2023.back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"equipment\"")
public class Equipment {
    private Long id;
    private Double grade;

}
