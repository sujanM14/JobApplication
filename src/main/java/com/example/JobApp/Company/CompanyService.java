package com.example.JobApp.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllComapanies();
    void createCompany(Company c);
    Company getComapanyById(Long id);
    boolean deleteCompanyById(Long id);
    boolean updateCompanyById(Long id, Company updateCompany);

}
