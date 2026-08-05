
package dao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnection;
import model.Interview;

public class InterviewDAO {
    // Schedule Interview
    public boolean scheduleInterview(Interview interview) {

        boolean status = false;

        String sql = "INSERT INTO interview(application_id, interview_date, interview_time, interview_mode, interview_status) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, interview.getApplicationId());
            ps.setString(2, interview.getInterviewDate());
            ps.setString(3, interview.getInterviewTime());
            ps.setString(4, interview.getInterviewMode());
            ps.setString(5, interview.getInterviewStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
 // View Interview Schedule
    public void viewInterview(int studentId) {

        String sql = "SELECT i.interview_date, i.interview_time, i.interview_mode, "
                   + "i.interview_status, j.job_role "
                   + "FROM interview i "
                   + "JOIN application a ON i.application_id = a.application_id "
                   + "JOIN job j ON a.job_id = j.job_id "
                   + "WHERE a.student_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\n===== Interview Schedule =====");

            while (rs.next()) {

                found = true;

                System.out.println("----------------------------");
                System.out.println("Job Role         : " + rs.getString("job_role"));
                System.out.println("Interview Date   : " + rs.getString("interview_date"));
                System.out.println("Interview Time   : " + rs.getString("interview_time"));
                System.out.println("Interview Mode   : " + rs.getString("interview_mode"));
                System.out.println("Interview Status : " + rs.getString("interview_status"));
            }

            if (!found) {
                System.out.println("No Interview Scheduled.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}