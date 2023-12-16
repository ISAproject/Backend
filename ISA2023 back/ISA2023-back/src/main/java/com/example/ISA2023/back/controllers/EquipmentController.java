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

    @GetMapping("/filtergrade/{rating}")
    public List<Equipment> findEquipmentByGrade(@PathVariable double rating)
    {
        List<Equipment> r=equipmentService.findEquipmentByGrade(rating);
        return equipmentService.findEquipmentByGrade(rating);
    }
    @GetMapping("/filtertype/{equipmentType}")
    public List<Equipment> findEquipmentByEquipmentType(@PathVariable EquipmentType equipmentType)
    {
        List<Equipment> r=equipmentService.findEquipmentByEquipmentType(equipmentType);
        return equipmentService.findEquipmentByEquipmentType(equipmentType);
    }
    @GetMapping("/searchbyname/{name}")
    public List<Equipment> findEquipmentByName(@PathVariable String name)
    {
        List<Equipment> r=equipmentService.findEquipmentByName(name);
        return equipmentService.findEquipmentByName(name);
    }
    @GetMapping("/searchbycompany/{companyId}")
    public List<Equipment> findEquipmentByCompany(@PathVariable Long companyId)
    {
        return equipmentService.findEquipmentByCompany(companyId);
    }
    @GetMapping()
    public List<Equipment> GetAllEquipment()
    {
        return equipmentService.GetAllEquipment();
    }
    @GetMapping("/{id}")
    public Equipment GetEquipmentById(@PathVariable Long id)
    {
        return equipmentService.GetEquipmentById(id);
    }
    @GetMapping("/{name}/{rating}")
    List<Equipment> findEquipmentByNameAndRating(@PathVariable String name, @PathVariable double rating)
    {
        return  equipmentService.findEquipmentByNameAndRating(name,rating);
    }

    @GetMapping("/forCompany/{id}")
    public  List<Equipment> findEquipmentByCompanyId(@PathVariable Long id){
        return equipmentService.findEquipmentByCompanyId(id);
    }



}
