package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.models.Company;
import com.example.ISA2023.back.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public  Company getCompany(@PathVariable Long id){
        return companyService.getById(id);
    }
    @PostMapping
    public Company create(@RequestBody Company company)
    {
        return companyService.create(company);
    }
    @RequestMapping(value = "/addadmin/{companyId}/{adminUsername}",
            produces = "application/json",
            method=RequestMethod.PUT)
    public Boolean giveCompanyAdmins(@PathVariable Long companyId, @PathVariable String adminUsername)
    {
        return companyService.giveCompanyAdmins(companyId,adminUsername);
    }
}
