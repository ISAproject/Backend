package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.models.ReservedDate;
import com.example.ISA2023.back.services.ReservedDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/reservedDate")
public class ReservedDateController {

    private final ReservedDateService reservedDateService;

    @Autowired
    public ReservedDateController(ReservedDateService reservedDateService) {
        this.reservedDateService = reservedDateService;
    }

    @PostMapping
    public ReservedDate create(@RequestBody ReservedDate reservedDate){
        return reservedDateService.create(reservedDate);
    }
}
