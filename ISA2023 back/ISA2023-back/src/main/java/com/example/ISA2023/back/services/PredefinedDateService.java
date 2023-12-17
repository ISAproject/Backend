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
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public PredefinedDateService(IPredefinedDateRepository predefinedDateRepository) {
        this.predefinedDateRepository = predefinedDateRepository;
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
