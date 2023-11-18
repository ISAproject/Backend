package com.example.ISA2023.back.services;

import com.example.ISA2023.back.models.Company;
import com.example.ISA2023.back.models.irepositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Company getById(Long id){
        return companyRepository.findById(id).orElse(null);
    }

    public List<Company> getSearchedCompanies(String content,double rating){
        return companyRepository.findByAddressNameRating(content,rating);
    }

    public List<Company> getSearchedRatingCompanies(double rating) {
        return companyRepository.findByRating(rating);
    }
    public Company update(long id, Company company){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()) {
            var existingCompany = optionalCompany.get();
            modelMapper.map(company, existingCompany);
            companyRepository.save(existingCompany);
            return existingCompany;
        }

        return null;
    }
    public Company create(Company company)
    {
        Company newCompany=new Company(company.getName(), company.getAddress(), company.getDescription(), company.getAvgGrade(),company.getEquipemntsFreeMilliseconds(), company.getAdministratorsId());
        companyRepository.save(newCompany);

        return newCompany;
    }

    public Boolean giveCompanyAdmins(Long companyId, Long adminId)
    {
        try 
        {
            var company= companyRepository.findById(companyId);
            List<Long>companyAdmins=company.get().getAdministratorsId();
            companyAdmins.add(adminId);
            company.get().setAdministratorsId(companyAdmins);
            companyRepository.save(company.get());
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}

