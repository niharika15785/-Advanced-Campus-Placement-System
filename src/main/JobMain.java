
package main;

import dao.JobDAO;
import model.Job;

public class JobMain {

    public static void main(String[] args) {

        Job job = new Job();

        job.setCompanyId(1);
        job.setJobRole("Java Developer");
        job.setJobLocation("Hyderabad");
        job.setPackageOffered(7.5);
        job.setMinCgpa(7.0);
        job.setLastDate("2026-08-30");
        job.setEligibleBranch("CSE");


        JobDAO dao = new JobDAO();

        boolean status = dao.postJob(job);

        if(status) {
            System.out.println("Job Posted Successfully!");
        } else {
            System.out.println("Job Posting Failed!");
        }

    }
}