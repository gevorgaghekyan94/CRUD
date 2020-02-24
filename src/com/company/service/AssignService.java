package com.company.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.company.MariaDBConstants.*;

public class AssignService {

    private static AssignService instance = null;

    public static AssignService getInstance() {
        if (instance == null) {
            instance = new AssignService();
            return instance;
        } else {
            return instance;
        }
    }

    public void assignTaskToUser (int taskId, int userId) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "UPDATE tasks SET userid = ? WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setInt(2, taskId);
                preparedStatement.setInt(1, userId);

                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void unAssignTaskToUser (int taskId) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "UPDATE tasks SET userid = 0 WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setInt(1, taskId);

                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
