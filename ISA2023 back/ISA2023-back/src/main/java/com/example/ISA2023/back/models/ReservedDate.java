package com.example.ISA2023.back.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class ReservedDate {
    @Id
    @SequenceGenerator(
            name="reserved_date_sequence",
            sequenceName = "reserved_date_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reserved_date_sequence"
    )
    private Long Id;
    private Long DateTimeInMS;
    private Long UserId;
    private List<Long> Equipments;

    private Boolean isPickedUp;

    public ReservedDate() {
    }

    public ReservedDate(Long id, Long dateTimeInMS, Long userId, List<Long> equipments, Boolean isPickedUp) {
        Id = id;
        DateTimeInMS = dateTimeInMS;
        UserId = userId;
        Equipments = equipments;
        this.isPickedUp = isPickedUp;
    }

    public ReservedDate(Long dateTimeInMS, Long userId, List<Long> equipments, Boolean isPickedUp) {
        DateTimeInMS = dateTimeInMS;
        UserId = userId;
        Equipments = equipments;
        this.isPickedUp = isPickedUp;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getDateTimeInMS() {
        return DateTimeInMS;
    }

    public void setDateTimeInMS(Long dateTimeInMS) {
        DateTimeInMS = dateTimeInMS;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public List<Long> getEquipments() {
        return Equipments;
    }

    public void setEquipments(List<Long> equipments) {
        Equipments = equipments;
    }

    public Boolean getPickedUp() {
        return isPickedUp;
    }

    public void setPickedUp(Boolean pickedUp) {
        isPickedUp = pickedUp;
    }
}
