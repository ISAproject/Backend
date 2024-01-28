package com.example.ISA2023.back.services;

import com.example.ISA2023.back.models.Company;
import com.example.ISA2023.back.models.Contract;
import com.example.ISA2023.back.models.irepositories.CompanyRepository;
import com.example.ISA2023.back.models.irepositories.IContractRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    private final IContractRepository contractRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public ContractService(IContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> getContracts(){
        return contractRepository.findAll();
    }

    public Contract create(Contract contract){
        Contract cont=getByUserId(contract.getUserId());
        if(cont==null){
            return  contractRepository.save(contract);
        }

        cont.setCompanyId(contract.getCompanyId());
        cont.setEquipments(contract.getEquipments());
        cont.setQuantity(contract.getQuantity());
        cont.setUserId(contract.getUserId());
        cont.setDateTimeInMS(contract.getDateTimeInMS());
        contractRepository.save(cont);
        return cont;

    }
    public Contract getByUserId(Long userId){
        return contractRepository.findByUserId(userId);
    }

    public void deleteByUserId(Long userId){
        contractRepository.deleteById(userId);
    }
}
