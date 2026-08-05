package main;
import java.util.Scanner;
import ui.ApplyJob;
import dao.StudentDAO;
import dao.JobDAO;
import ui.ViewAppliedJobs;
public class StudentLogin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.println("3. View Applied Jobs");
        System.out.println("4. Logout");

        StudentDAO dao = new StudentDAO();

        boolean status = dao.loginStudent(email, password);

        if (status) {

            System.out.println("Login Successful");

            System.out.println("\n===== Student Menu =====");
            System.out.println("1. View Jobs");
            System.out.println("2. Apply Job");
            System.out.println("3. Logout");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            switch(choice) {

            case 1:
                JobDAO jobDao = new JobDAO();
                jobDao.viewJobs();
                break;

            case 2:
                ApplyJob apply = new ApplyJob();
                apply.applyJob();
                break;

            case 3:
                ViewAppliedJobs view = new ViewAppliedJobs();
                view.viewJobs();
                break;

            case 4:
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