package ui;

import java.util.Scanner;

import dao.JobDAO;
import model.Job;

public class PostJob {

    public void postJob() {

        Scanner sc = new Scanner(System.in);

        Job job = new Job();

        System.out.print("Enter Company ID: ");
        job.setCompanyId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Job Role: ");
        job.setJobRole(sc.nextLine());

        System.out.print("Enter Job Location: ");
        job.setJobLocation(sc.nextLine());

        System.out.print("Enter Package Offered: ");
        job.setPackageOffered(sc.nextDouble());

        System.out.print("Enter Minimum CGPA: ");
        job.setMinCgpa(sc.nextDouble());
        sc.nextLine();

        System.out.print("Enter Last Date (YYYY-MM-DD): ");
        job.setLastDate(sc.nextLine());

        System.out.print("Enter Eligible Branch: ");
        job.setEligibleBranch(sc.nextLine());

        JobDAO dao = new JobDAO();

        boolean status = dao.postJob(job);

        if (status) {
            System.out.println("Job Posted Successfully.");
        } else {
            System.out.println("Failed to Post Job.");
        }
    }
}