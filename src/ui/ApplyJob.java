package ui;

import java.util.Scanner;

import dao.ApplicationDAO;
import model.Application;

public class ApplyJob {

    public void applyJob() {

        Scanner sc = new Scanner(System.in);

        Application application = new Application();

        System.out.print("Enter Student ID: ");
        application.setStudentId(sc.nextInt());

        System.out.print("Enter Job ID: ");
        application.setJobId(sc.nextInt());

        application.setStatus("Pending");

        ApplicationDAO dao = new ApplicationDAO();

        boolean result = dao.applyJob(application);

        if (result) {
            System.out.println("Job Applied Successfully");
        } else {
            System.out.println("Failed to Apply Job");
        }
    }
}