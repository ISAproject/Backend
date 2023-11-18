package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.models.Company;
import com.example.ISA2023.back.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public List<Company> getAll(){return companyService.getCompanies();}
    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public  Company getCompany(@PathVariable Long id){
        return companyService.getById(id);
    }
    @GetMapping("/search/{content}/{rating}")
    public List<Company> getSearchedCompanies(@PathVariable String content,@PathVariable double rating){return companyService.getSearchedCompanies(content,rating);}

    @GetMapping("/searchRating/{rating}")
    public List<Company> getSearchedRatingCompanies(@PathVariable double rating){return companyService.getSearchedRatingCompanies(rating);}

}
