	package model;

public class Student {

	    private int studentId;
	    private String name;
	    private String email;
	    private String branch;
	    private double cgpa;
	    private String password;
	    private String phone;

	    // Default Constructor
	    public Student() {
	    }

	    // Getters and Setters
	    public int getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(int studentId) {
	        this.studentId = studentId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getBranch() {
	        return branch;
	    }

	    public void setBranch(String branch) {
	        this.branch = branch;
	    }

	    public double getCgpa() {
	        return cgpa;
	    }

	    public void setCgpa(double cgpa) {
	        this.cgpa = cgpa;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }
}
