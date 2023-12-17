package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.dtos.ReservedDatesDto;
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

    @PostMapping
    public ReservedDate create(@RequestBody ReservedDate reservedDate){
        return reservedDateService.create(reservedDate);
    }

    @PostMapping("reserve/{email}")
    public ReservedDate reserve(@RequestBody ReservedDate reservedDate,@PathVariable String email){
        ReservedDate reservation=reservedDateService.create(reservedDate);
        reservedDateService.sendConfirmationEmail(email,reservedDate);
        return reservation;
    }

    @GetMapping("alldates/{companyId}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<ReservedDatesDto> GetByCompany(@PathVariable Long companyId )
    {
        return reservedDateService.GetByCompany(companyId);
    }

    @GetMapping("weekly/{companyId}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<ReservedDatesDto> GetByCompanyByWeek(@PathVariable Long companyId )
    {
        return reservedDateService.GetByCompanyByWeek(companyId);
    }

    @GetMapping("monthly/{companyId}/{month}/{year}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<ReservedDatesDto> GetByCompanyByMonth(@PathVariable Long companyId, @PathVariable int month, @PathVariable int year )
    {
        return reservedDateService.GetByCompanyByMonth(companyId,month,year);
    }

    @GetMapping("yearly/{companyId}/{year}")
    @PreAuthorize("hasAuthority('ROLL_COMPANY_ADMIN')")
    public List<ReservedDatesDto> GetByCompanyByYear(@PathVariable Long companyId, @PathVariable int year )
    {
        return reservedDateService.GetByCompanyByYear(companyId,year);
    }
}
