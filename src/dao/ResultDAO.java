package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnection;
import model.Result;

public class ResultDAO {

    // Update Result
    public boolean addResult(Result result) {

        boolean status = false;

        String sql = "INSERT INTO result(application_id, result_status, remarks) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, result.getApplicationId());
            ps.setString(2, result.getResultStatus());
            ps.setString(3, result.getRemarks());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}