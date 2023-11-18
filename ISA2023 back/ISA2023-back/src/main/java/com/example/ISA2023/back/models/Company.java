package com.example.ISA2023.back.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table
public class Company {
    @Id
    @SequenceGenerator(
            name="company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private String description;
    private Double avgGrade;
    private List<LocalDate> equipemntsFree;
    private List<String> administrators;

    public Company() {
    }

    public Company(Long id, String name, String address, String description, Double avgGrade, List<LocalDate> equipemntsFree, List<String> administrators) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.avgGrade = avgGrade;
        this.equipemntsFree = equipemntsFree;
        this.administrators = administrators;
    }

    public Company(String name, String address, String description, Double avgGrade, List<LocalDate> equipemntsFree, List<String> administrators) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.avgGrade = avgGrade;
        this.equipemntsFree = equipemntsFree;
        this.administrators = administrators;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public List<LocalDate> getEquipemntsFree() {
        return equipemntsFree;
    }

    public List<String> getAdministrators() {
        return administrators;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public void setEquipemntsFree(List<LocalDate> equipemntsFree) {
        this.equipemntsFree = equipemntsFree;
    }

    public void setAdministrators(List<String> administrators) {
        this.administrators = administrators;
    }
}
