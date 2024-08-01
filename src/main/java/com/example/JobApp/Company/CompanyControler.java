package com.example.JobApp.Company;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/companies")
public class CompanyControler {
    private CompanyService companyService;
    public CompanyControler (CompanyService companyService){
        this.companyService=companyService;
    }

   
   @GetMapping
   public ResponseEntity<List<Company>> getAllCompanies() {
       return new ResponseEntity<>(companyService.getAllComapanies(),HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
       Company company=companyService.getComapanyById(id);
       if(company!=null){
        return new ResponseEntity<>(company,HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PostMapping
   public ResponseEntity<String> createCompany(@RequestBody Company company) {
       companyService.createCompany(company);
       return new ResponseEntity<>("Company created successfully",HttpStatus.OK);   
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
     boolean isDeleted=companyService.deleteCompanyById(id);
     if(isDeleted){
        return new ResponseEntity<>("Company is deleted successfully",HttpStatus.OK);
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   
   
   @PutMapping("/{id}")
   public  ResponseEntity<String> updateCompanyById(@PathVariable Long id, @RequestBody Company updatedCompany) {
       boolean isUpdated=companyService.updateCompanyById(id, updatedCompany);
       if(isUpdated){
        return new ResponseEntity<>("Company has been updated successfully",HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
}
