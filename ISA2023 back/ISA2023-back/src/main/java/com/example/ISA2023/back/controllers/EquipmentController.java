package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.models.Equipment;
import com.example.ISA2023.back.models.EquipmentType;
import com.example.ISA2023.back.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/filtergrade")
    public List<Equipment> findEqupmentByGrade(@RequestBody double rating)
    {
        return equipmentService.findEqupmentByGrade(rating);
    }
    @GetMapping("/filtertype")
    public List<Equipment> findEqupmentByEquipmentType(@RequestBody EquipmentType equipmentType)
    {
        return equipmentService.findEqupmentByEquipmentType(equipmentType);
    }
}
