package com.example.ISA2023.back.services;

import com.example.ISA2023.back.models.irepositories.IPredefinedDateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredefinedDateService {
    private final IPredefinedDateRepository predefinedDateRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public PredefinedDateService(IPredefinedDateRepository predefinedDateRepository) {
        this.predefinedDateRepository = predefinedDateRepository;
    }
}
