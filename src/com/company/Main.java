package com.company;

import com.company.controller.Controller;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Controller controller = Controller.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("--------MAIN-MENU--------");
            System.out.println("1. Enter User CRUD");
            System.out.println("2. Enter Task CRUD");
            System.out.println("3. Assign task to user");
            System.out.println("4. Unassign task from user");
            System.out.println("5. For exit");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("--------USER-MENU-------");
                    System.out.println("1. Create user");
                    System.out.println("2. Find all users");
                    System.out.println("3. Find user by id");
                    System.out.println("4. Update user by id");
                    System.out.println("5. Delete user by id");
                    System.out.println("6. Back to previous menu");
                    System.out.println("7. For exit");

                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            controller.initAndCreateUser();
                            break;
                        case 2:
                            System.out.println(controller.findAllUsers());
                            break;
                        case 3:
                            System.out.println(controller.findUserById());
                            break;
                        case 4:
                            controller.updateUser();
                            break;
                        case 5:
                            controller.deleteUserById();
                            break;
                        case 6:
                            break;
                        case 7:
                            loop = false;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("--------TASK-MENU--------");
                    System.out.println("1. Create task");
                    System.out.println("2. Find all tasks");
                    System.out.println("3. Find task by id");
                    System.out.println("4. Update task by id");
                    System.out.println("5. Delete task by id");
                    System.out.println("6. Back to previous menu");
                    System.out.println("7. For exit");
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            controller.initAndCreateTask();
                            break;
                        case 2:
                            System.out.println(controller.findAllTasks());
                            break;
                        case 3:
                            System.out.println(controller.findTaskById());
                            break;
                        case 4:
                            controller.updateTask();
                            break;
                        case 5:
                            controller.deleteTaskById();
                            break;
                        case 6:
                            break;
                        case 7:
                            loop = false;
                            break;
                    }
                    break;
                case 3:
                    controller.assignTaskToUser();
                    break;
                case 4:
                    controller.unAssignTaskToUser();
                    break;
                case 5:
                    loop = false;
                    break;

            }
        }
    }
}
