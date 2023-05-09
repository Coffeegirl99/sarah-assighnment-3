package com.coderscampus.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {

	public void validateUser(String fileName) throws IOException {

		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			String data;
			
			System.out.println("Enter your email:");
			
			try (Scanner scanner = new Scanner(System.in)) {
				String userInput = scanner.nextLine();
				
				System.out.println("Enter your password:");
				userInput = scanner.nextLine();
			}
			while ((data = fileReader.readLine()) != null) {
				String[] userArray = data.split(",");
				String username = userArray[0];
				String password = userArray[1];
				String name = userArray[2];
			}

		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {

				}
			}
		}
	}
}
