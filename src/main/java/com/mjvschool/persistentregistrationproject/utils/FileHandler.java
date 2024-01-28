package com.mjvschool.persistentregistrationproject.utils;

import com.mjvschool.persistentregistrationproject.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileHandler {
    private static final String FILE_PATH = "user_data.txt";

    public static void writeToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.toString());
            writer.newLine();
            System.out.println("User added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static List<User> readFromFile() {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userValues = line.split(", ");

                User user = new User(userValues[0], Long.parseLong(userValues[1].split("=")[1]), userValues[2].split("=")[1]);

                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }

        return users;
    }

}
