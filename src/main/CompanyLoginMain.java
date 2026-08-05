package main;

import java.util.Scanner;

import dao.ApplicationDAO;
import dao.CompanyDAO;
import dao.JobDAO;
import ui.PostJob;

public class CompanyLoginMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        CompanyDAO dao = new CompanyDAO();

        // Login and get Company ID
        int companyId = dao.loginCompany(email, password);

        if (companyId != -1) {

            System.out.println("Login Successful");

            System.out.println("\n===== Company Menu =====");
            System.out.println("1. Post Job");
            System.out.println("2. View Jobs");
            System.out.println("3. View Applicants");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                PostJob post = new PostJob();
                post.postJob();
                break;

            case 2:
                JobDAO jobDao = new JobDAO();
                jobDao.viewJobs();
                break;

            case 3:
                ApplicationDAO appDao = new ApplicationDAO();
                appDao.viewApplicants(companyId);
                break;

            case 4:
                JobDAO deleteDao = new JobDAO();

                System.out.print("Enter Job ID to Delete: ");
                int jobId = sc.nextInt();

                if (deleteDao.deleteJob(jobId)) {
                    System.out.println("Job Deleted Successfully!");
                } else {
                    System.out.println("Job Deletion Failed!");
                }
                break;

            case 5:
                JobDAO searchDao = new JobDAO();

                sc.nextLine(); // clear buffer
                System.out.print("Enter Job Role: ");
                String role = sc.nextLine();

                searchDao.searchJob(role);
                break;

            case 6:
                System.out.println("Logged Out Successfully");
                break;

            default:
                System.out.println("Invalid Choice");
            }
        } else {
            System.out.println("Invalid Email or Password");
        }

        sc.close();
    }
}