package com.example.JobApp.Company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.JobApp.Company.Company;
import com.example.JobApp.Company.CompanyRepository;
import com.example.JobApp.Company.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService{
    
    private CompanyRepository companyRepository;
    public CompanyServiceImpl (CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }
    @Override
    public List<Company> getAllComapanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company c) {
        companyRepository.save(c);
    }

    @Override
    public Company getComapanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCompanyById(Long id, Company updateCompany) {
        Optional<Company> optionalCompany=companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company=optionalCompany.get();
            company.setDescription(updateCompany.getDescription());
            company.setJobs(updateCompany.getJobs());
            company.setName(updateCompany.getName());
            companyRepository.save(company);
            return true;
        }
        return false;
    }
    
}
