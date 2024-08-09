package com.employee.compensation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.employee.compensation.model.Employee;
import com.employee.compensation.service.EmployeeCompensationService;

public class EmployeeCompensationServiceApp {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeCompensationServiceApp.class);

	   public static void main(String[] args) {
		   
		EmployeeCompensationService employeeService = new EmployeeCompensationService();

		Optional<List<Employee>> employeeUpdatedSalaryDetails = employeeService.getEmployeeUpdatedSalaryDetails();
		logger.info("updated employee salary Details={}", employeeUpdatedSalaryDetails.get());

	}

}
