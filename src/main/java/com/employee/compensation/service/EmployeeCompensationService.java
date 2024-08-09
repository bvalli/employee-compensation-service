package com.employee.compensation.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.employee.compensation.model.Employee;
import com.employee.compensation.repo.EmployeeCompensationRepository;


public class EmployeeCompensationService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeCompensationService.class);

	
	public Optional<List<Employee>> getEmployeeUpdatedSalaryDetails() {
		
		logger.info("getEmployeeUpdatedSalaryDetails method started {}");
		
		List<Employee> employeeList=EmployeeCompensationRepository.getEmployeeList();
		
		List<Employee> sortedEmployeeList = employeeList.stream()
				.peek(s -> s.setEmployeeSalary((long) (s.getEmployeeSalary() + s.getEmployeeSalary() * (EmployeeCompensationRepository.retrieveAppraisalFactor(s.getDepartment()) / 100))))
				.sorted(Comparator.comparing(Employee::getEmployeeSalary).reversed())
				.collect(Collectors.toList());
		logger.info("After_Sorted_Employee_list {}"+sortedEmployeeList);
		return Optional.of(sortedEmployeeList);
		
	}
}
