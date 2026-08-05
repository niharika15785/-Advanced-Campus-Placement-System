package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Company;

public class CompanyDAO {

    // Company Registration
    public boolean registerCompany(Company company) {

        boolean status = false;

        String sql = "INSERT INTO company(company_name, email, password, location, role, package_offered, min_cgpa) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getEmail());
            ps.setString(3, company.getPassword());
            ps.setString(4, company.getLocation());
            ps.setString(5, company.getRole());
            ps.setDouble(6, company.getPackageOffered());
            ps.setDouble(7, company.getMinCgpa());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
 // Company Login
    public int loginCompany(String email, String password) {

        String sql = "SELECT company_id FROM company WHERE email=? AND password=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("company_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
         // Delete Company
    public boolean deleteCompany(int companyId) {

        boolean status = false;

        String sql = "DELETE FROM company WHERE company_id=?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, companyId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // View Companies (Admin Menu)
    public void viewCompanies() {

        String sql = "SELECT * FROM company";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-------------------------");
                System.out.println("Company ID : " + rs.getInt("company_id"));
                System.out.println("Company Name : " + rs.getString("company_name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Location : " + rs.getString("location"));
                System.out.println("Role : " + rs.getString("role"));
                System.out.println("Package : " + rs.getDouble("package_offered"));
                System.out.println("Min CGPA : " + rs.getDouble("min_cgpa"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
     // View Applicants
        public void viewApplicants(int companyId) {

            String sql = "SELECT s.student_id, s.name, s.email, s.branch, s.cgpa, j.job_role "
                       + "FROM application a "
                       + "JOIN student s ON a.student_id = s.student_id "
                       + "JOIN job j ON a.job_id = j.job_id "
                       + "WHERE j.company_id = ?";

            try {

                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, companyId);

                ResultSet rs = ps.executeQuery();

                System.out.println("\n===== Applicants =====");

                boolean found = false;

                while (rs.next()) {

                    found = true;

                    System.out.println("----------------------------");
                    System.out.println("Student ID : " + rs.getInt("student_id"));
                    System.out.println("Name       : " + rs.getString("name"));
                    System.out.println("Email      : " + rs.getString("email"));
                    System.out.println("Branch     : " + rs.getString("branch"));
                    System.out.println("CGPA       : " + rs.getDouble("cgpa"));
                    System.out.println("Applied For: " + rs.getString("job_role"));
                }
                if (!found) {
                    System.out.println("No Applicants Found.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}