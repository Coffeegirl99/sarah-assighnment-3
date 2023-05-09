package com.coderscampus.application;

import java.io.IOException;

import com.coderscampus.service.UserService;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {

		UserService loginApplication = new UserService();
		 loginApplication.validateUser("data.txt");
	}

}
