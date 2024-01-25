package com.example.ISA2023.back.dtos;

public class ReservedDatesDto {
    private Long id;
    private Long duration;
    private Long dateTimeInMS;
    private String companyName;
    private Long companyAdminId;
    public ReservedDatesDto(Long id,Long duration, Long dateTimeInMS, String companyName,Long companyAdminId) {
        this.duration = duration;
        this.dateTimeInMS = dateTimeInMS;
        this.companyName = companyName;
        this.id=id;
        this.companyAdminId=companyAdminId;
    }

    public Long getCompanyAdminId() {
        return companyAdminId;
    }

    public void setCompanyAdminId(Long companyAdminId) {
        this.companyAdminId = companyAdminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDateTimeInMS() {
        return dateTimeInMS;
    }

    public void setDateTimeInMS(Long dateTimeInMS) {
        this.dateTimeInMS = dateTimeInMS;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
