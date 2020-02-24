package com.company.service;

import com.company.Task;
import com.company.User;

import java.sql.*;
import java.util.ArrayList;

import static com.company.MariaDBConstants.*;

public class TaskService {

    private static TaskService instance = null;

    public static TaskService getInstance() {
        if (instance == null) {
            instance = new TaskService();
            return instance;
        } else {
            return instance;
        }
    }

    public void createTask(Task task) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("Connected to database");

                String query = "INSERT INTO tasks(name, state) VALUES (?,?)";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, task.getName());
                preparedStatement.setString(2, task.getState());

                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            System.out.println("Maybe incorrect usernameGev or password");
            ex.printStackTrace();
        }
    }

    public ArrayList<Task> findAllTasks() {

        ArrayList<Task> tasks = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "SELECT * FROM tasks";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();


                while (resultSet.next()) {
                    Task task = new Task();
                    task.setName(resultSet.getString("name"));
                    task.setState(resultSet.getString("state"));
                    tasks.add(task);
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasks;
    }

    public Task findTaskById(int enteredId) {

        Task task = new Task();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "SELECT * FROM tasks WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setInt(1, enteredId);

                ResultSet resultSet = preparedStatement.executeQuery();


                while (resultSet.next()) {
                    task.setName(resultSet.getString("name"));
                    task.setState(resultSet.getString("state"));
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return task;
    }

    public void updateTask(int enteredId, Task task) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "UPDATE tasks SET name = ?, state = ? WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setInt(3, enteredId);
                preparedStatement.setString(1, task.getName());
                preparedStatement.setString(2, task.getState());

                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteTaskById(int enteredId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "DELETE FROM tasks WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setInt(1, enteredId);

                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
