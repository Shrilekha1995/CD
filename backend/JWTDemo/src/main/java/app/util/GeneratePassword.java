package app.util;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {

	static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)){
			String password=sc.next();
			System.out.println(encoder.encode(password));
		}
	}

}
