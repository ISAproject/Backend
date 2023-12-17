package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.models.Equipment;
import com.example.ISA2023.back.models.ReservedDate;
import com.example.ISA2023.back.services.ReservedDateService;
import com.example.ISA2023.back.user.User;
import com.example.ISA2023.back.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("reservedDates/{id}")
    public List<ReservedDate> getReservedDatesByUserId(@PathVariable Long id){

        return reservedDateService.getReservedDatesByUserId(id);
    }

}
