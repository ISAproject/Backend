package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.dtos.TrackingOrderDto;
import com.example.ISA2023.back.dtos.ReservedDatesDto;
import com.example.ISA2023.back.dtos.ReservedDatesForCalendarDto;
import com.example.ISA2023.back.models.Equipment;
import com.example.ISA2023.back.models.ReservedDate;
import com.example.ISA2023.back.services.ReservedDateService;
import com.example.ISA2023.back.user.User;
import com.example.ISA2023.back.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/reservedDate")
public class ReservedDateController {

    private final ReservedDateService reservedDateService;

    @Autowired
    public ReservedDateController(ReservedDateService reservedDateService) {
        this.reservedDateService = reservedDateService;
    }

    @GetMapping("/{id}")
    public ReservedDate findById(@PathVariable Long id){
        return reservedDateService.FindById(id);
    }
    @GetMapping("equipment/{id}")
    public List<Equipment> findEquipmentByReservationDateId(@PathVariable Long id){
        return reservedDateService.findEquipmentByReservationDateId(id);
    }
    @GetMapping
    public List<ReservedDate> getAll(){
        return reservedDateService.getAll();
    }

    @GetMapping("trackingOrder/{id}")
    public List<TrackingOrderDto> getTrackingsByEquipmentId(@PathVariable Long id){
        return reservedDateService.getTrackingsByEquipmentId(id);
    }
    @PostMapping
    public ReservedDate create(@RequestBody ReservedDate reservedDate){
        return reservedDateService.create(reservedDate);
    }

    @GetMapping("reservedDatesByCompanyId/{id}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<TrackingOrderDto> getReservedDatesByCompanyId(@PathVariable Long id){
        return reservedDateService.getReservedDatesByCompanyId(id);
    }

    @PostMapping("reserve/{email}")
    public ReservedDate reserve(@RequestBody ReservedDate reservedDate,@PathVariable String email){
        ReservedDate reservation=reservedDateService.create(reservedDate);
        reservedDateService.sendConfirmationEmail(email,reservedDate);
        return reservation;
    }
    @GetMapping("reservedDates/{id}")
    public List<ReservedDatesDto> getReservedDatesByUserId(@PathVariable Long id){

        return reservedDateService.getReservedDatesByUserId(id);
    }
    @GetMapping("alldates/{companyId}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<ReservedDatesForCalendarDto> GetByCompany(@PathVariable Long companyId )
    {
        return reservedDateService.GetByCompany(companyId);
    }

    @GetMapping("weekly/{companyId}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<ReservedDatesForCalendarDto> GetByCompanyByWeek(@PathVariable Long companyId )
    {
        return reservedDateService.GetByCompanyByWeek(companyId);
    }

    @GetMapping("monthly/{companyId}/{month}/{year}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<ReservedDatesForCalendarDto> GetByCompanyByMonth(@PathVariable Long companyId, @PathVariable int month, @PathVariable int year )
    {
        return reservedDateService.GetByCompanyByMonth(companyId,month,year);
    }

    @GetMapping("yearly/{companyId}/{year}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<ReservedDatesForCalendarDto> GetByCompanyByYear(@PathVariable Long companyId, @PathVariable int year )
    {
        return reservedDateService.GetByCompanyByYear(companyId,year);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public void DeleteById(@PathVariable Long id){
        reservedDateService.DeleteById(id);
    }
}
