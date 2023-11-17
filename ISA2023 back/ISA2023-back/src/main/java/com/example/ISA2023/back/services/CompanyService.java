package com.example.ISA2023.back.services;

import com.example.ISA2023.back.models.Company;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class CompanyService {
    public List<Company> getCompanies(){
        return List.of(
                new Company(
                        1L,
                        "company",
                        "address",
                        "description",
                        9.2,
                        List.of(LocalDate.of(2020, Month.FEBRUARY, 10)),
                        List.of(new String("administrator"))
                )
        );
    }
}
