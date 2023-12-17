package com.example.ISA2023.back.services;

import com.example.ISA2023.back.models.PredefinedDate;
import com.example.ISA2023.back.models.irepositories.IPredefinedDateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PredefinedDateService {
    private final IPredefinedDateRepository predefinedDateRepository;
    private final CompanyService companyService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public PredefinedDateService(IPredefinedDateRepository predefinedDateRepository, CompanyService companyService) {
        this.predefinedDateRepository = predefinedDateRepository;
        this.companyService = companyService;
    }

    public List<PredefinedDate> getAll(){
        return predefinedDateRepository.findAll();
    }

    public PredefinedDate create(PredefinedDate predefinedDate, long companyId){
        var company = companyService.getById(companyId);
        var savedPredefinedDate = predefinedDateRepository.save(predefinedDate);

        List<Long> predefineDatesId = company.getPredefinedDatesId();
        predefineDatesId.add(savedPredefinedDate.getId());
        company.setPredefinedDatesId(predefineDatesId);

        companyService.update(companyId, company);
        return savedPredefinedDate;
    }

    public void deleteById(long id, long companyId){
        predefinedDateRepository.deleteById(id);

        var company = companyService.getById(companyId);
        List<Long> predefineDatesId = company.getPredefinedDatesId();

        company.setPredefinedDatesId(predefineDatesId
                                        .stream().filter(p -> !p.equals(id)).toList());

        companyService.update(companyId, company);
    }

    public List<PredefinedDate> findAllById(List<Long> listId){
        List<PredefinedDate> dates=new ArrayList<>();
        for (Long id:listId) {
            dates.add(predefinedDateRepository.findById(id).get());
        }
        return  dates;
    }

    public PredefinedDate update(PredefinedDate dateToUpdate){
        return predefinedDateRepository.save(dateToUpdate);
    }
}
