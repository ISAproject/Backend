package com.example.ISA2023.back.controllers;

import com.example.ISA2023.back.dtos.ContractDto;
import com.example.ISA2023.back.models.Company;
import com.example.ISA2023.back.models.Contract;
import com.example.ISA2023.back.models.CustomMessage;
import com.example.ISA2023.back.models.MQConfig;
import com.example.ISA2023.back.services.CompanyService;
import com.example.ISA2023.back.services.ContractService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/contract")
public class ContractController {
    private final ContractService contractService;
    @Autowired
    private RabbitTemplate template;
    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public List<Contract> getAll(){return contractService.getContracts();}
    @PostMapping
    public Contract createContarct(@RequestBody Contract contract){return contractService.create(contract);}

    @GetMapping("/getByUserId/{userId}")
    public Contract getContarctByUserId(@PathVariable Long userId){return contractService.getByUserId(userId);}
    @GetMapping("/getByCompanyId/{companyId}")
    public List<ContractDto> getContarctByCompanyId(@PathVariable Long companyId){return contractService.getByCompanyId(companyId);}
    @DeleteMapping("/{userId}")
    public void deleteByUserId(@PathVariable Long userId){contractService.deleteByUserId(userId);}

    @PostMapping("/message")
    public String sendMessage(@RequestBody CustomMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.QUEUE_SENDING,
                message);

        return "Message sent";
    }

}
