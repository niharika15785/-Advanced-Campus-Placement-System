package main;

import java.util.Scanner;

import dao.StudentDAO;

public class ChangePasswordMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Old Password: ");
        String oldPassword = sc.nextLine();

        System.out.print("Enter New Password: ");
        String newPassword = sc.nextLine();

        StudentDAO dao = new StudentDAO();

        boolean status = dao.changePassword(email, oldPassword, newPassword);

        if(status) {
            System.out.println("Password Changed Successfully!");
        }
        else {
            System.out.println("Password Change Failed!");
        }
        sc.close();
    }
}