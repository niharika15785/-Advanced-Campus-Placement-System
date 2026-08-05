package main;

import dao.InterviewDAO;
import model.Interview;

public class InterviewMain {

    public static void main(String[] args) {

        Interview interview = new Interview();

        // Sample Data
        interview.setApplicationId(1);
        interview.setInterviewDate("2026-08-10");
        interview.setInterviewTime("10:00 AM");
        interview.setInterviewMode("Online");
        interview.setInterviewStatus("Scheduled");

        InterviewDAO dao = new InterviewDAO();

        boolean status = dao.scheduleInterview(interview);

        if (status) {
            System.out.println("Interview Scheduled Successfully!");
        } else {
            System.out.println("Interview Scheduling Failed!");
        }
    }
}