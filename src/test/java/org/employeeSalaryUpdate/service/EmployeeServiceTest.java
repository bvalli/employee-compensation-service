package org.employeeSalaryUpdate.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.employee.compensation.model.Employee;
import com.employee.compensation.repo.EmployeeCompensationRepository;

class EmployeeServiceTest {

	List<Employee> employeeList = EmployeeCompensationRepository.getEmployeeList();
	
	List<Employee> sortedList=null;
	
	
	@Test
	void testHighestSalaryDetails() {
		
		sortedList = getSortedEmployeeSalaryDetails();
		Assertions.assertEquals(sortedList.get(0).getEmployeeSalary(), 660000);
	}
	
	
	@Test
	void testLowestSalaryDetails() {
		sortedList = getSortedEmployeeSalaryDetails();
		Assertions.assertEquals(sortedList.get(5).getEmployeeSalary(), 504000);
	}
	
	@Test
	void testLowestSalaryDetailsNegative() {
		sortedList = getSortedEmployeeSalaryDetails();
		Assertions.assertNotEquals(sortedList.get(5).getEmployeeSalary(), 580000);
	}
	@Test
	void testHighesSalaryDetailsNegative() {
		sortedList = getSortedEmployeeSalaryDetails();
		Assertions.assertNotEquals(sortedList.get(0).getEmployeeSalary(), 504000);
	}
	
	public List<Employee> getSortedEmployeeSalaryDetails(){
		
		
		List<Employee> sortedEmployeeList = employeeList.stream()
				.peek(s -> s.setEmployeeSalary((long) (s.getEmployeeSalary() + s.getEmployeeSalary()
						* (EmployeeCompensationRepository.retrieveAppraisalFactor(s.getDepartment())/ 100))))
				.sorted(Comparator.comparing(Employee::getEmployeeSalary).reversed()).collect(Collectors.toList());
		System.out.println(sortedEmployeeList);
		return sortedEmployeeList;
	}

}
