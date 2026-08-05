
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Application;

public class ApplicationDAO {

    // Apply Job
    public boolean applyJob(Application application) {

        boolean status = false;

        String sql = "INSERT INTO application(student_id, job_id, status) VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, application.getStudentId());
            ps.setInt(2, application.getJobId());
            ps.setString(3, application.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }


    // View Applied Jobs
    public void viewAppliedJobs(int studentId) {

        String sql = "SELECT * FROM application WHERE student_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("----------------------");
                System.out.println("Application ID : " 
                        + rs.getInt("application_id"));

                System.out.println("Job ID : " 
                        + rs.getInt("job_id"));

                System.out.println("Status : " 
                        + rs.getString("status"));
            }

            if (!found) {
                System.out.println("No Applications Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // View All Applications
    public void viewAllApplications() {

        String sql = "SELECT * FROM application";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== ALL APPLICATIONS =====");

            while (rs.next()) {

                System.out.println("---------------------------");
                System.out.println("Application ID : " + rs.getInt("application_id"));
                System.out.println("Student ID     : " + rs.getInt("student_id"));
                System.out.println("Job ID         : " + rs.getInt("job_id"));
                System.out.println("Status         : " + rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // Update Application Status
    public boolean updateApplicationStatus(int applicationId, String status) {

        String sql = "UPDATE application SET status=? WHERE application_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, applicationId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public void viewApplicants(int companyId) {

        String sql = "SELECT a.application_id, s.student_id, s.name, s.email, s.branch, s.cgpa, j.job_role, a.status "
                   + "FROM application a "
                   + "JOIN student s ON a.student_id = s.student_id "
                   + "JOIN job j ON a.job_id = j.job_id "
                   + "WHERE j.company_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, companyId);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\n===== APPLICANTS LIST =====");

            while (rs.next()) {

                found = true;

                System.out.println("----------------------------");
                System.out.println("Application ID : " + rs.getInt("application_id"));
                System.out.println("Student ID     : " + rs.getInt("student_id"));
                System.out.println("Student Name   : " + rs.getString("name"));
                System.out.println("Email          : " + rs.getString("email"));
                System.out.println("Branch         : " + rs.getString("branch"));
                System.out.println("CGPA           : " + rs.getDouble("cgpa"));
                System.out.println("Job Role       : " + rs.getString("job_role"));
                System.out.println("Status         : " + rs.getString("status"));
            }

            if (!found) {
                System.out.println("No Applicants Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
