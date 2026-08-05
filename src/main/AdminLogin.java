package main;

import java.util.Scanner;

import dao.AdminDAO;
import dao.ApplicationDAO;
import dao.CompanyDAO;
import dao.JobDAO;
import dao.StudentDAO;

public class AdminLogin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Admin Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        AdminDAO dao = new AdminDAO();

        boolean status = dao.login(email, password);

        if (status) {

            while (true) {

                System.out.println("\n===== ADMIN MENU =====");
                System.out.println("1. View Students");
                System.out.println("2. View Companies");
                System.out.println("3. View Jobs");
                System.out.println("4. View All Applications");
                System.out.println("5. Update Application Status");
                System.out.println("6. Logout");

                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                case 1:
                    StudentDAO studentDAO = new StudentDAO();
                    studentDAO.viewAllStudents();
                    break;

                case 2:
                    CompanyDAO companyDAO = new CompanyDAO();
                    companyDAO.viewCompanies();
                    break;

                case 3:
                    JobDAO jobDAO = new JobDAO();
                    jobDAO.viewJobs();
                    break;

                case 4:
                    ApplicationDAO appDao = new ApplicationDAO();
                    appDao.viewAllApplications();
                    break;

                case 5:
                    ApplicationDAO updateDao = new ApplicationDAO();

                    System.out.print("Enter Application ID: ");
                    int applicationId = sc.nextInt();

                    sc.nextLine(); // Clear buffer

                    System.out.print("Enter Status (Selected/Rejected/Pending): ");
                    String statusText = sc.nextLine();

                    if (updateDao.updateApplicationStatus(applicationId, statusText)) {
                        System.out.println("Application Status Updated Successfully!");
                    } else {
                        System.out.println("Update Failed!");
                    }
                    break;

                case 6:
                    System.out.println("Logged Out Successfully");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
                }
            }

        } else {
            System.out.println("Invalid Email or Password");
        }
    }
}