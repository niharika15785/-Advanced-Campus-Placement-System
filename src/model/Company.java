package model;

public class Company {

    private int companyId;
    private String companyName;
    private String email;
    private String password;
    private String location;
    private String role;
    private double packageOffered;
    private double minCgpa;

    public Company() {
    }
    public Company(String companyName, String email, String password,
                   String location, String role,
                   double packageOffered, double minCgpa) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.location = location;
        this.role = role;
        this.packageOffered = packageOffered;
        this.minCgpa = minCgpa;
    }
    public int getCompanyId() {
        return companyId;
    }
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public double getPackageOffered() {
        return packageOffered;
    }
    public void setPackageOffered(double packageOffered) {
        this.packageOffered = packageOffered;
    }
    public double getMinCgpa() {
        return minCgpa;
    }
    public void setMinCgpa(double minCgpa) {
        this.minCgpa = minCgpa;
    }
}