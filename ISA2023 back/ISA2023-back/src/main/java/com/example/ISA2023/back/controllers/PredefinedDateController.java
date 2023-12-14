package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.services.CompanyService;
import com.example.ISA2023.back.services.PredefinedDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/predefinedDate")
public class PredefinedDateController {
    private final PredefinedDateService predefinedDateService;
    @Autowired
    public PredefinedDateController(PredefinedDateService predefinedDateService) {
        this.predefinedDateService = predefinedDateService;
    }
}
