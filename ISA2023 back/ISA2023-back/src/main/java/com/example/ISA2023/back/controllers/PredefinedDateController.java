package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.models.PredefinedDate;
import com.example.ISA2023.back.services.CompanyService;
import com.example.ISA2023.back.services.PredefinedDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/predefinedDate")
public class PredefinedDateController {
    private final PredefinedDateService predefinedDateService;
    @Autowired
    public PredefinedDateController(PredefinedDateService predefinedDateService) {
        this.predefinedDateService = predefinedDateService;
    }
    @GetMapping
    public List<PredefinedDate> getAll(){
        return predefinedDateService.getAll();
    }

    @PostMapping("/{id}")
    public PredefinedDate create(@RequestBody PredefinedDate predefinedDate, @PathVariable long id){
        return predefinedDateService.create(predefinedDate, id);
    }

    @DeleteMapping("/{id}/{companyId}")
    public void deleteById(@PathVariable long id, @PathVariable long companyId){
        predefinedDateService.deleteById(id, companyId);
    }
}
