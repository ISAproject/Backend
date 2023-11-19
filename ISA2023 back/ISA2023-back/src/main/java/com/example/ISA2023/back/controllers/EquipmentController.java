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
        List<Equipment> r=equipmentService.findEqupmentByGrade(rating);
        return equipmentService.findEqupmentByGrade(rating);
    }
    @GetMapping("/filtertype")
    public List<Equipment> findEqupmentByEquipmentType(@RequestBody EquipmentType equipmentType)
    {
        List<Equipment> r=equipmentService.findEqupmentByEquipmentType(equipmentType);
        return equipmentService.findEqupmentByEquipmentType(equipmentType);
    }
    @GetMapping("/searchbyname")
    public List<Equipment> findEqupmentByName(@RequestBody String name)
    {
        List<Equipment> r=equipmentService.findEqupmentByName(name);
        return equipmentService.findEqupmentByName(name);
    }

    @GetMapping("/forCompany/{id}")
    public  List<Equipment> findEquipmentByCompanyId(@PathVariable Long id){
        return equipmentService.findEquipmentByCompanyId(id);
    }
}
