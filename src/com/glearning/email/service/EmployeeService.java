package com.glearning.email.service;

import com.glearning.email.model.Employee;

/**
 * This class will delegate all the logic to our CredentialService
 * @author pradeep
 *
 */
public class EmployeeService {
	
	//private final CredentialService credentialService;
	
	/*
	 * public EmployeeService(CredentialService credentialService) {
	 * this.credentialService = credentialService; }
	 */	
	public void generateEmailAddress(Employee employee) {
		String emailAddress = CredentialService.generateEmailAddress(employee.getFirstName(), employee.getLastName(), employee.getDept());
		employee.setEmailAddress(emailAddress);
	}
	
	public Employee saveCredentials(int length, Employee employee) {
		String password = CredentialService.generatePassword(length);
		employee.setPassword(password);
		return employee;
	}
	
	public void printEmployeeDetails(Employee employee) {
		CredentialService.showCredentials(employee);
	}

}
