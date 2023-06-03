package com.coderscampus.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.coderscampus.User.User;

public class UserService {

	public List<User> loadUsersFromFile(String fileName) throws IOException {

		List<User> users = new ArrayList<>();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
			String data;

			// Store each line into its own array
			while ((data = fileReader.readLine()) != null) {
				String[] userArray = data.split(",");
				String username = userArray[0];
				String password = userArray[1];
				String name = userArray[2];
				users.add(new User(username, password, name));
			}
		}
		return users;
	}

	public static User validateUser(List<User> users, String userInputEmail, String userInputPassword) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(userInputEmail) && user.getPassword().equals(userInputPassword)) {
				return user;
			} // validation check for if matched
		}
		return null;
	}

}