package com.example.ISA2023.back.models.irepositories;

import com.example.ISA2023.back.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long > {
}
