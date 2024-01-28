package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.models.Company;
import com.example.ISA2023.back.models.Contract;
import com.example.ISA2023.back.services.CompanyService;
import com.example.ISA2023.back.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/contract")
public class ContractController {
    private final ContractService contractService;
    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public List<Contract> getAll(){return contractService.getContracts();}
    @PostMapping
    public Contract createContarct(@RequestBody Contract contract){return contractService.create(contract);}

    @GetMapping("/{userId}")
    public Contract getContarctByUserId(@PathVariable Long userId){return contractService.getByUserId(userId);}

    @DeleteMapping("/{userId}")
    public void deleteByUserId(@PathVariable Long userId){contractService.deleteByUserId(userId);}

}
