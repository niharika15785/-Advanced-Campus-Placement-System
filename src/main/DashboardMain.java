package main;

import dao.DashboardDAO;

public class DashboardMain {

    public static void main(String[] args) {

        DashboardDAO dao = new DashboardDAO();

        System.out.println("\n========== ADMIN DASHBOARD ==========");

        System.out.println("Total Students      : " + dao.getTotalStudents());
        System.out.println("Total Companies     : " + dao.getTotalCompanies());
        System.out.println("Total Jobs          : " + dao.getTotalJobs());
        System.out.println("Total Applications  : " + dao.getTotalApplications());
        System.out.println("Total Interviews    : " + dao.getTotalInterviews());
        System.out.println("Total Selected      : " + dao.getTotalSelected());

        System.out.println("=====================================");
    }
}