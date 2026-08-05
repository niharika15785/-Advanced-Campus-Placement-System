
package main;

import java.util.Scanner;

import dao.StudentDAO;
import model.Student;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        System.out.println("===== Campus Placement System =====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            Student student = new Student();

            System.out.print("Enter Name: ");
            student.setName(sc.nextLine());

            System.out.print("Enter Email: ");
            student.setEmail(sc.nextLine());

            System.out.print("Enter Password: ");
            student.setPassword(sc.nextLine());

            System.out.print("Enter Branch: ");
            student.setBranch(sc.nextLine());

            System.out.print("Enter CGPA: ");
            student.setCgpa(sc.nextDouble());
            sc.nextLine();

            System.out.print("Enter Phone: ");
            student.setPhone(sc.nextLine());

            if (dao.registerStudent(student)) {
                System.out.println("Student Registered Successfully!");
            } else {
                System.out.println("Registration Failed!");
            }

        } else if (choice == 2) {

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            if (dao.loginStudent(email, password)) {

                System.out.println("\nLogin Successful!");

                while (true) {

                    System.out.println("\n===== STUDENT DASHBOARD =====");
                    System.out.println("1. View Profile");
                    System.out.println("2. Update Profile");
                    System.out.println("3. Logout");
                    System.out.print("Enter Choice: ");

                    int ch = sc.nextInt();
                    sc.nextLine();

                    if (ch == 1) {

                        Student student = dao.getStudentByEmail(email);

                        System.out.println("\n===== STUDENT PROFILE =====");
                        System.out.println("ID      : " + student.getStudentId());
                        System.out.println("Name    : " + student.getName());
                        System.out.println("Email   : " + student.getEmail());
                        System.out.println("Branch  : " + student.getBranch());
                        System.out.println("CGPA    : " + student.getCgpa());
                        System.out.println("Phone   : " + student.getPhone());

                    } else if (ch == 2) {

                        Student student = dao.getStudentByEmail(email);

                        System.out.print("Enter New Name: ");
                        student.setName(sc.nextLine());

                        System.out.print("Enter New Branch: ");
                        student.setBranch(sc.nextLine());

                        System.out.print("Enter New CGPA: ");
                        student.setCgpa(sc.nextDouble());
                        sc.nextLine();

                        System.out.print("Enter New Phone: ");
                        student.setPhone(sc.nextLine());

                        if (dao.updateStudent(student)) {
                            System.out.println("Profile Updated Successfully!");
                        } else {
                            System.out.println("Update Failed!");
                        }

                    } else if (ch == 3) {

                        System.out.println("Logged Out Successfully!");
                        break;

                    } else {

                        System.out.println("Invalid Choice!");
                    }
                }

            } else {
                System.out.println("Invalid Email or Password!");
            }

        } else {
            System.out.println("Invalid Choice!");
        }

        sc.close();
    }
}