package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Interview;


public class Interview {

    private int interviewId;
    private int applicationId;
    private String interviewDate;
    private String interviewTime;
    private String interviewMode;
    private String interviewStatus;

    public int getInterviewId() {
        return interviewId;
    }
    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }
    public int getApplicationId() {
        return applicationId;
    }
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
    public String getInterviewDate() {
        return interviewDate;
    }
    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }
    public String getInterviewTime() {
        return interviewTime;
    }
    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }
    public String getInterviewMode() {
        return interviewMode;
    }
    public void setInterviewMode(String interviewMode) {
        this.interviewMode = interviewMode;
    }
    public String getInterviewStatus() {
        return interviewStatus;
    }
    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }
}