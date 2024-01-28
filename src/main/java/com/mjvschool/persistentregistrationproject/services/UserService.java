package com.mjvschool.persistentregistrationproject.services;

import com.mjvschool.persistentregistrationproject.models.User;
import com.mjvschool.persistentregistrationproject.utils.UserUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class UserService {
    private List<User> users;
    private final UserUtil userUtil;

    public UserService(UserUtil userUtil) {
        this.users = new ArrayList<>();
        this.userUtil = userUtil;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public void displayUser(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
                System.out.println("\n Welcome to the persistence project, MJV School, performance options: ");
                System.out.println("1. Add new user");
                System.out.println("2. View all users");
                System.out.println("3. Exit");
                System.out.print("Now choose one of the options shown: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        userUtil.addUser(this);
                        break;
                    case 2:
                        userUtil.displayAllUsers(this);
                        break;
                    case 3:
                        System.out.println("Closing the program. Thanks!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }catch (InputMismatchException e) {
                    System.out.println("Invalid Input. Please enter a valid number.");
                    scanner.nextLine();
            }
        }
    }

}