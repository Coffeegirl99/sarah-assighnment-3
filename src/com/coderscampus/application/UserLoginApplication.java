package com.coderscampus.application;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.coderscampus.User.User;
import com.coderscampus.service.UserService;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {

		UserService userService = new UserService();

		try {
			List<User> users = userService.loadUsersFromFile("data.txt");
			login(users);
		} catch (IOException e) {
			System.out.println("Error reading user data from file.");
		}
	}

	public static void login(List<User> users) {

		try (Scanner scanner = new Scanner(System.in)) {
			int userAttempts = 0;

			while (userAttempts <= 4) {
				System.out.println("Enter your email:");
				String userInputEmail = scanner.nextLine();
				System.out.println("Enter your password:");
				String userInputPassword = scanner.nextLine();

				User matchedUser = UserService.validateUser(users, userInputEmail, userInputPassword);

				if (matchedUser != null) {
					System.out.println("Welcome: " + matchedUser.getName());
					return; // Terminate the application
				} else {// if it does not matched
					System.out.println("Invalid login, please try again");
					userAttempts++;
				}
			}
			// User used all attempts, so they get locked out
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
	}
}
