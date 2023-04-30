package com.coderscampus.userValidation;

import java.io.IOException;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {

		UserService loginApplication = new UserService();
		 loginApplication.validateUser("data.txt");
	}

}
