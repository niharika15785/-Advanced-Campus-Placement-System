package ui;

import java.util.Scanner;

import dao.ApplicationDAO;

public class ViewAppliedJobs {

    public void viewJobs() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        ApplicationDAO dao = new ApplicationDAO();

        dao.viewAppliedJobs(studentId);
    }
}