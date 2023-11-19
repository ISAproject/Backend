package com.example.ISA2023.back.services;

import com.example.ISA2023.back.models.Equipment;
import com.example.ISA2023.back.models.EquipmentType;
import com.example.ISA2023.back.models.irepositories.CompanyRepository;
import com.example.ISA2023.back.models.irepositories.IEquipmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    private final IEquipmentRepository equipmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public EquipmentService(IEquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> findEqupmentByGrade(double rating)
    {
        return equipmentRepository.findEqupmentByGrade(rating);
    }
    public List<Equipment> findEqupmentByEquipmentType(EquipmentType eqtype)
    {
        return equipmentRepository.findEqupmentByEquipmentType(eqtype);
    }
    public List<Equipment> findEqupmentByName(String name)
    {
        return equipmentRepository.findEqupmentByName(name.toLowerCase());
    }

    public List<Equipment> findEquipmentByCompanyId(Long id){
        return equipmentRepository.findEquipmentByCompanyId(id);
    }
}
