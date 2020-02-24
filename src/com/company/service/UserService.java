package com.company.service;

import com.company.User;

import java.sql.*;
import java.util.ArrayList;

import static com.company.MariaDBConstants.*;
import static com.company.MariaDBConstants.PASS;

public class UserService {

    private static UserService instance = null;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
            return instance;
        } else {
            return instance;
        }
    }


    public void createUser(User user) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("Connected to database");

                String query = "INSERT INTO users(name, surname) VALUES (?,?)";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());

                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            System.out.println("Maybe incorrect usernameGev or password");
            ex.printStackTrace();
        }
    }

    public ArrayList<User> findAllUsers() {

        ArrayList<User> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "SELECT * FROM users";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();


                while (resultSet.next()) {
                    User user = new User();
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    users.add(user);
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public User findUserById(int enteredId) {

        User user = new User();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "SELECT * FROM users WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, enteredId);

                ResultSet resultSet = preparedStatement.executeQuery();


                while (resultSet.next()) {
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public void updateUSer(int enteredId, User user) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "UPDATE users SET name = ?, surname = ? WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(3, enteredId);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());

                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUserById(int enteredId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("Connected to database");

                String query = "DELETE FROM users WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setInt(1, enteredId);

                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
