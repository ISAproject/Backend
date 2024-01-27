package com.example.ISA2023.back.services;

import com.example.ISA2023.back.models.Company;
import com.example.ISA2023.back.models.Contract;
import com.example.ISA2023.back.models.irepositories.CompanyRepository;
import com.example.ISA2023.back.models.irepositories.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    private final IContractRepository contractRepository;
    @Autowired
    public ContractService(IContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> getContracts(){
        return contractRepository.findAll();
    }
}
