package com.example.ISA2023.back.models.irepositories;

import com.example.ISA2023.back.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long > {

}
