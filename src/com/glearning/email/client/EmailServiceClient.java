package com.glearning.email.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.glearning.email.model.Employee;
import com.glearning.email.service.CredentialService;
import com.glearning.email.service.EmployeeService;

public class EmailServiceClient {

	//private static CredentialService credentialService = new CredentialService();
	private static EmployeeService employeeService = new EmployeeService();

	// entry point to access the service
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter first name");
		String firstName = scanner.next();

		System.out.println("Please enter last name");
		String lastName = scanner.next();

		/**
		 * dd/MM/yy - 18/05/83 dd/MMM/yyyy - 18/MAY/1983
		 */
		System.out.println("Please enter date of birth in dd/MM/yyyy format");
		String strDOB = scanner.next();
		LocalDate dob = null;
		Employee newHire = null;
		try {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dob = LocalDate.parse(strDOB, pattern);
		} catch (Exception exception) {
			System.out.println("invalid date format passed. Example: 18/03/1977");
		}

		if (dob != null) {
			newHire = new Employee(firstName, lastName, dob);
		} else {
			newHire = new Employee(firstName, lastName);
		}

		System.out.println("Enter your department");
		String dept = scanner.next();
		newHire.setDept(dept);
		employeeService.generateEmailAddress(newHire);

		System.out.println("Enter your options from the following:: ");
		System.out.println("1 -> Generate Password ");
		System.out.println("2 -> Show Details ");

		int option = scanner.nextInt();

		switch (option) {
		case 1:
			employeeService.saveCredentials(8, newHire);
			employeeService.printEmployeeDetails(newHire);
			break;
		case 2:
			employeeService.printEmployeeDetails(newHire);
			break;
		}
		
		scanner.close();
	}
}
