package com.mjvschool.persistentregistrationproject.utils;

import com.mjvschool.persistentregistrationproject.models.User;
import com.mjvschool.persistentregistrationproject.services.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class UserUtil {

    private static List<User> users;

    public UserUtil() {
        users = new ArrayList<>();
    }

    public void addUser(UserService userService) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Age: ");
        Long age = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Job: ");
        String profession = scanner.nextLine();

        User newUser = new User(fullName, age, profession);
        users.add(newUser);
        FileHandler.writeToFile(newUser);
    }

    public void displayAllUsers(UserService userService) {
        List<User> users = FileHandler.readFromFile();

        System.out.println("\nUser list:");
        for (User user : users) {
            System.out.println("Full name: " + user.getFullName());
            System.out.println("Age: " + user.getAge());
            System.out.println("Job: " + user.getProfession());
            System.out.println();
        }
    }
}
