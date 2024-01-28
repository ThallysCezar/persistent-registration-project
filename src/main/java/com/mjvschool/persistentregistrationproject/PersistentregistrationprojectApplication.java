package com.mjvschool.persistentregistrationproject;

import com.mjvschool.persistentregistrationproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PersistentregistrationprojectApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(PersistentregistrationprojectApplication.class, args);
	}

	@Override
	public void run(String... args) {
		userService.displayUser();
	}
}
