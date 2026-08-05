package main;

import dao.ResultDAO;
import model.Result;

public class ResultMain {

    public static void main(String[] args) {

        Result result = new Result();

        result.setApplicationId(1);
        result.setResultStatus("Selected");
        result.setRemarks("Congratulations!");

        ResultDAO dao = new ResultDAO();

        boolean status = dao.addResult(result);

        if (status) {
            System.out.println("Result Added Successfully!");
        } else {
            System.out.println("Failed to Add Result!");
        }
    }
}