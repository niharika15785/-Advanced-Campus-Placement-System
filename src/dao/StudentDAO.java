package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Student;

public class StudentDAO {

    // Register Student
    public boolean registerStudent(Student student) {

        String sql = "INSERT INTO student(name, email, password, branch, cgpa, phone) VALUES(?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPassword());
            ps.setString(4, student.getBranch());
            ps.setDouble(5, student.getCgpa());
            ps.setString(6, student.getPhone());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // Student Login
    public boolean loginStudent(String email, String password) {

        String sql = "SELECT * FROM student WHERE email=? AND password=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // View Student Profile
    public Student getStudentByEmail(String email) {

        String sql = "SELECT * FROM student WHERE email=?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setBranch(rs.getString("branch"));
                student.setCgpa(rs.getDouble("cgpa"));
                student.setPhone(rs.getString("phone"));

                return student;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Update Student Profile
    public boolean updateStudent(Student student) {

        String sql = "UPDATE student SET name=?, branch=?, cgpa=?, phone=? WHERE email=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getBranch());
            ps.setDouble(3, student.getCgpa());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getEmail());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // View All Students
    public void viewAllStudents() {

        String sql = "SELECT * FROM student";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            while(rs.next()) {

                System.out.println("-------------------------");

                System.out.println("ID     : " + rs.getInt("student_id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Email  : " + rs.getString("email"));
                System.out.println("Branch : " + rs.getString("branch"));
                System.out.println("CGPA   : " + rs.getDouble("cgpa"));
                System.out.println("Phone  : " + rs.getString("phone"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    // Delete Student
    public boolean deleteStudent(int studentId) {

        String sql = "DELETE FROM student WHERE student_id=?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // Change Password
    public boolean changePassword(String email, String oldPassword, String newPassword) {

        String sql = "UPDATE student SET password=? WHERE email=? AND password=?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newPassword);
            ps.setString(2, email);
            ps.setString(3, oldPassword);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}