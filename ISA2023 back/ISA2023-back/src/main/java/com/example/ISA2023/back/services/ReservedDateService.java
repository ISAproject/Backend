package com.example.ISA2023.back.services;

import com.example.ISA2023.back.models.ReservedDate;
import com.example.ISA2023.back.models.irepositories.IReservedDateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservedDateService {
    private  final IReservedDateRepository reservedDateRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ReservedDateService(IReservedDateRepository reservedDateRepository) {
        this.reservedDateRepository = reservedDateRepository;
    }

    public ReservedDate create(ReservedDate reservedDate){
        return reservedDateRepository.save(reservedDate);
    }
}
