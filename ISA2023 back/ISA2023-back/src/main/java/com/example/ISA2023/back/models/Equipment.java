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
    private String name;
    private Double grade;
    private EquipmentType type;
    private String Description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Equipment(Long id, String name, Double grade, EquipmentType type, String description) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.type = type;
        Description = description;
    }

    public Equipment(String name, Double grade, EquipmentType type, String description) {
        this.name = name;
        this.grade = grade;
        this.type = type;
        Description = description;
    }
    public Equipment(){}
}
