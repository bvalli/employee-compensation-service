package com.employee.compensation.repo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.employee.compensation.model.Employee;
import com.employee.compensation.util.EmployeeConstants;

public class EmployeeCompensationRepository {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeCompensationRepository.class);
	public static List<Employee> getEmployeeList() {
		
		logger.info("getEmployeeList method started {}");
		
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employee1=new Employee();
		employee1.setEmployeeName("Joey");
		employee1.setEmployeeSalary(480000);
		employee1.setDepartment(EmployeeConstants.SALES);
		
		employeeList.add(employee1);
		
		Employee employee2=new Employee();
		employee2.setEmployeeName("Ross");
		employee2.setDepartment(EmployeeConstants.OPERATIONS);
		employee2.setEmployeeSalary(550000);
		
		employeeList.add(employee2);

		Employee employee3=new Employee();
		employee3.setEmployeeName("Monica");
		employee3.setDepartment(EmployeeConstants.MANAGER);
		employee3.setEmployeeSalary(450000);
		
		employeeList.add(employee3);

		Employee employee4=new Employee();
		employee4.setEmployeeName("Phoebe");
		employee4.setDepartment(EmployeeConstants.SALES);
		employee4.setEmployeeSalary(600000);
		
		employeeList.add(employee4);

		Employee employee5=new Employee();
		employee5.setEmployeeName("Chandler");
		employee5.setDepartment(EmployeeConstants.DEVELOPER);
		employee5.setEmployeeSalary(530000);
		
		employeeList.add(employee5);

		Employee employee6=new Employee();
		employee6.setEmployeeName("Rachel");
		employee6.setDepartment(EmployeeConstants.OPERATIONS);
		employee6.setEmployeeSalary(580000);
		
		employeeList.add(employee6);
		logger.info("Employee_Info={}",employeeList);
		return employeeList;
	}

	/**
	 * @param designation to identify appraisal Factor.
	 * @return appraisalFactor which returns double value for appraisal.
	 */

	public static double retrieveAppraisalFactor(String designation) {
		double appraisalFactor = 0;
		switch (designation) {
		case EmployeeConstants.SALES:
			appraisalFactor = EmployeeConstants.APPRAISAL_FACTOR_TEN;
			break;
		case EmployeeConstants.OPERATIONS:
			appraisalFactor = EmployeeConstants.APPRAISAL_FACTOR_EIGHT;
			break;
		case EmployeeConstants.MANAGER:
			appraisalFactor = EmployeeConstants.APPRAISAL_FACTOR_TWELVE;
			break;
		case EmployeeConstants.DEVELOPER:
			appraisalFactor = EmployeeConstants.APPRAISAL_FACTOR_FIFTEEN;
			break;
		}
		return appraisalFactor;
	}

}
