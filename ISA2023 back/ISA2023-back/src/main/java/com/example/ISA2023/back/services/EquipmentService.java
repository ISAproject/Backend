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

    public List<Equipment> findEquipmentByGrade(double rating)
    {
        return equipmentRepository.findEquipmentByGrade(rating);
    }
    public List<Equipment> findEquipmentByEquipmentType(EquipmentType eqtype)
    {
        return equipmentRepository.findEquipmentByEquipmentType(eqtype);
    }
    public List<Equipment> findEquipmentByName(String name)
    {
        return equipmentRepository.findEquipmentByName(name.toLowerCase());
    }
    public List<Equipment> findEquipmentByCompany(Long companyId)
    {
        return equipmentRepository.findEquipmentByCompany(companyId);
    }
    public List<Equipment> GetAllEquipment()
    {
        return equipmentRepository.GetAllEquipment();
    }
    public Equipment GetEquipmentById(Long id)
    {
        return equipmentRepository.GetEquipmentById(id);
    }
    public List<Equipment> findEquipmentByNameAndRating(String name, double rating)
    {
        return equipmentRepository.findEquipmentByNameAndRating(name,rating);
    }

    public List<Equipment> findEquipmentByCompanyId(Long id){
        return equipmentRepository.findEquipmentByCompanyId(id);
    }
}
