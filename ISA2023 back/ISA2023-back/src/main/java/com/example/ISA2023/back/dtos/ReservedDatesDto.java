package com.example.ISA2023.back.dtos;

public class ReservedDatesDto {
    private Long duration;
    private Long dateTimeInMS;
    private String companyName;

    public ReservedDatesDto(Long duration, Long dateTimeInMS, String companyName) {
        this.duration = duration;
        this.dateTimeInMS = dateTimeInMS;
        this.companyName = companyName;
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
