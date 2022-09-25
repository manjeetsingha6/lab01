package com.glearning.email.service;

import java.util.Random;

import com.glearning.email.model.Employee;

public class CredentialService {

	// all the constants should be declared as static, final and the naming
	// convention is to use CAPS and _ as delimitter
	private static final String DOMAIN_NAME = "abc.com";
	private static final String DELIMITTER = "";
	private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "1234567890";
	private static final String SPECIAL_CHARS = "!@#$%^&*()_-";

	/**
	 * Generate password
	 */
	public static String generatePassword(int length) {

		// value =
		// ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_-
		String value = UPPER_CASE + LOWER_CASE + NUMBERS + SPECIAL_CHARS;
		Random random = new Random();

		/*
		 * [0]='' [1]='' [2]='' [3]='' [4]='' [5]='' [6]='' [7]=''
		 */
		char[] password = new char[length];

		for (int i = 0; i < length; i++) {
			password[i] = value.charAt(random.nextInt(value.length()));
		}
		System.out.println("Password generated is "+ String.valueOf(password));
		return String.valueOf(password);
	}

	// implement the generation of email address
	/*
	 * format of the email address firsnamelastname@dep.comp.com input - firstname -
	 * lastname - department - company/domain - Fixed
	 * 
	 */
	public static String generateEmailAddress(String firstName, String lastName, String department) {
		String emailAddress = firstName + DELIMITTER + lastName + "@" + department + DOMAIN_NAME;
		return emailAddress;

	}

	/**
	 * Display the credentials of the employee
	 */
	public static void showCredentials(Employee employee) {
		System.out.println("==== Displaying the details of the employee - start ====");
		System.out.println("First Name :: " + employee.getFirstName());
		System.out.println("Last Name :: " + employee.getLastName());
		System.out.println("Email Address :: " + employee.getEmailAddress());
		System.out.println("Password :: " + employee.getPassword());
		if (employee.getDateOfBirth() != null) {
			System.out.println("Date of Birth :: " + employee.getDateOfBirth());
		}
		System.out.println("==== Displaying the details of the employee - end ====");
	}

}
