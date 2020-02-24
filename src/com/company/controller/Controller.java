package com.company.controller;

import com.company.Task;
import com.company.User;
import com.company.service.AssignService;
import com.company.service.TaskService;
import com.company.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.MariaDBConstants.*;

public class Controller {

    private static Controller instance = null;
    private final UserService userService = UserService.getInstance();
    private final TaskService taskService = TaskService.getInstance();
    private final AssignService assignService = AssignService.getInstance();
    Scanner scanner = new Scanner(System.in);

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
            return instance;
        } else {
            return instance;
        }
    }

    public void initAndCreateUser() {
        User user = new User();
        System.out.println("Enter user name");
        user.setName(scanner.nextLine());
        System.out.println("Enter user surname");
        user.setSurname(scanner.nextLine());
        userService.createUser(user);
    }

    public ArrayList<User> findAllUsers() {
        return userService.findAllUsers();
    }

    public User findUserById() {
        System.out.println("Enter id of user that you want to find");
        return userService.findUserById(Integer.parseInt(scanner.nextLine()));
    }

    public void updateUser() {
        System.out.println("Enter id of user that you want to update");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        System.out.println("Enter user surname");
        String surname = scanner.nextLine();
        User user = new User(name, surname);
        userService.updateUSer(id, user);
    }

    public void deleteUserById() {
        System.out.println("Enter user id that you want to delete");
        userService.deleteUserById(Integer.parseInt(scanner.nextLine()));
    }

    public void initAndCreateTask() {
        Task task = new Task();
        System.out.println("Enter task name");
        task.setName(scanner.nextLine());
        task.setState("To Do");
        taskService.createTask(task);
    }

    public ArrayList<Task> findAllTasks() {
        return taskService.findAllTasks();
    }

    public Task findTaskById() {
        System.out.println("Enter id of task that you want to find");
        return taskService.findTaskById(Integer.parseInt(scanner.nextLine()));
    }

    public void updateTask() {
        System.out.println("Enter id of task that you want to update");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter task name");
        String name = scanner.nextLine();
        System.out.println("Enter task state");
        String state = scanner.nextLine();
        Task task = new Task(name,state);
        taskService.updateTask(id,task);
    }

    public void deleteTaskById() {
        System.out.println("Enter task id that you want to delete");
        taskService.deleteTaskById(Integer.parseInt(scanner.nextLine()));
    }

    public void assignTaskToUser () {
        System.out.println("Enter user id");
        int userid = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter task id");
        int taskid = Integer.parseInt(scanner.nextLine());
        assignService.assignTaskToUser(taskid,userid);

    }

    public void unAssignTaskToUser () {
        System.out.println("Enter task id");
        int taskid = Integer.parseInt(scanner.nextLine());
        assignService.unAssignTaskToUser(taskid);

    }
}
