package com.springboot.dbauthentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {


	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/contactUs")
	public String getMessage() {
		
		return "<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				"    <title>Contact Us</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <h1>Contact Us</h1>\n" +
				"    <p>\n" +
				"        If you have any questions or need assistance, please feel free to reach out to us.\n" +
				"    </p>\n" +
				"\n" +
				"    <h2>Contact Information</h2>\n" +
				"    <ul>\n" +
				"        <li><strong>Email:</strong> contact@example.com</li>\n" +
				"        <li><strong>Phone:</strong> +1 (123) 456-7890</li>\n" +
				"        <li><strong>Address:</strong> 123 Main Street, City, State ZIP</li>\n" +
				"    </ul>\n" +
				"\n" +
				"    <h2>Business Hours</h2>\n" +
				"    <p>\n" +
				"        We are open Monday through Friday from 9:00 AM to 5:00 PM.\n" +
				"    </p>\n" +
				"</body>\n" +
				"</html>\n";
	}

	public static void main(String a[]){

		String password = "123456";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		System.out.print(encodedPassword);
	}
}
