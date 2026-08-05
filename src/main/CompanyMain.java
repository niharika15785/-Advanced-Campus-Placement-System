package main;

import dao.CompanyDAO;
import model.Company;

public class CompanyMain {
    public static void main(String[] args) {

        // Create Company Object
        Company company = new Company();

        // Set Company Details
        company.setCompanyName("TCS");
        company.setEmail("tcs@gmail.com");
        company.setPassword("12345");
        company.setLocation("Hyderabad");
        company.setRole("Java Developer");
        company.setPackageOffered(7.5);
        company.setMinCgpa(7.0);
 
        // Create DAO Object
        CompanyDAO dao = new CompanyDAO();

        // Register Company
        boolean status = dao.registerCompany(company);

        if (status) {
            System.out.println("Company Registered Successfully!");
        } else {
            System.out.println("Company Registration Failed!");
        }
    }
}