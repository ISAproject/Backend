package com.example.ISA2023.back.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"equipment\"")
public class Equipment {
    @Id
    @SequenceGenerator(
            name = "equipment_sequence",
            sequenceName = "equipment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "equipment_sequence"
    )
    private Long id;
    private Double grade;
    private EquipmentType type;
}
