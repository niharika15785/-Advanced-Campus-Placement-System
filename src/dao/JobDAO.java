
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Job;

public class JobDAO {
	// Post Job
	public boolean postJob(Job job) {

		boolean status = false;

		String sql = "INSERT INTO job(company_id, job_role, job_location, package_offered, min_cgpa, last_date, eligible_branch) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, job.getCompanyId());
			ps.setString(2, job.getJobRole());
			ps.setString(3, job.getJobLocation());
			ps.setDouble(4, job.getPackageOffered());
			ps.setDouble(5, job.getMinCgpa());
			ps.setString(6, job.getLastDate());
			ps.setString(7, job.getEligibleBranch());

			int rows = ps.executeUpdate();

			if (rows > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// View Posted Jobs
	public void viewJobs() {

		String sql = "SELECT * FROM job";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println("----------------------");
				System.out.println("Job ID : " + rs.getInt("job_id"));
				System.out.println("Company ID : " + rs.getInt("company_id"));
				System.out.println("Role : " + rs.getString("job_role"));
				System.out.println("Location : " + rs.getString("job_location"));
				System.out.println("Package : " + rs.getDouble("package_offered"));
				System.out.println("Min CGPA : " + rs.getDouble("min_cgpa"));
				System.out.println("Branch : " + rs.getString("eligible_branch"));
				System.out.println("Last Date : " + rs.getString("last_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Delete Job
	public boolean deleteJob(int jobId) {

		String sql = "DELETE FROM job WHERE job_id=?";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, jobId);

			int rows = ps.executeUpdate();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// Search Job by Role
	public void searchJob(String role) {

		String sql = "SELECT * FROM job WHERE job_role LIKE ?";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "%" + role + "%");

			ResultSet rs = ps.executeQuery();

			boolean found = false;

			System.out.println("\n===== SEARCH RESULTS =====");

			while (rs.next()) {

				found = true;

				System.out.println("----------------------");
				System.out.println("Job ID : " + rs.getInt("job_id"));
				System.out.println("Company ID : " + rs.getInt("company_id"));
				System.out.println("Role : " + rs.getString("job_role"));
				System.out.println("Location : " + rs.getString("job_location"));
				System.out.println("Package : " + rs.getDouble("package_offered"));
				System.out.println("Min CGPA : " + rs.getDouble("min_cgpa"));
				System.out.println("Eligible Branch : " + rs.getString("eligible_branch"));
				System.out.println("Last Date : " + rs.getString("last_date"));
			}

			if (!found) {
				System.out.println("No Jobs Found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}