package com.example.ISA2023.back.dtos;

public class TrackingOrderDto {
    private Long id;
    private String userName;
    private String companyAdminName;
    private Boolean pickedUp;
    private Long dateTimeInMs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyAdminName() {
        return companyAdminName;
    }

    public void setCompanyAdminName(String companyAdminName) {
        this.companyAdminName = companyAdminName;
    }

    public Boolean getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(Boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public Long getDateTimeInMs() {
        return dateTimeInMs;
    }

    public void setDateTimeInMs(Long dateTimeInMs) {
        this.dateTimeInMs = dateTimeInMs;
    }
}
