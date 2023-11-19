package com.example.ISA2023.back.models.irepositories;

import com.example.ISA2023.back.models.ReservedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservedDateRepository extends JpaRepository<ReservedDate, Long > {
}
