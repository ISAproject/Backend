package com.example.ISA2023.back.models.irepositories;

import com.example.ISA2023.back.models.Company;
import com.example.ISA2023.back.models.Equipment;
import com.example.ISA2023.back.models.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEquipmentRepository extends JpaRepository<Equipment, Long > {
    @Query("SELECT e FROM Equipment e WHERE e.grade>?1")
    List<Equipment> findEqupmentByGrade(double rating);
    @Query("SELECT e FROM Equipment e WHERE e.type=?1")
    List<Equipment> findEqupmentByEquipmentType(EquipmentType et);
    @Query("SELECT e FROM Equipment e WHERE LOWER(e.name) LIKE ?1%")
    List<Equipment> findEqupmentByName(String name);
}
