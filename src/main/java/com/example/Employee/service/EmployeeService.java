package com.example.Employee.service;

import org.springframework.data.jpa.repository.Query;

import com.example.Employee.model.Credentials;
import com.example.Employee.model.Employee;
import com.example.Employee.repositary.EmployeeRepositary;

public class EmployeeService {
	EmployeeRepositary repositary;

	public boolean checkEmployee(Credentials cred) {
		boolean userExist = false;
		try {

			if (repositary.equals(cred.getPassword()) && repositary.equals(cred.getName())) {
				userExist = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userExist;

	}

	public String createEmployee(Employee emp) {
		try {
			repositary.save(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emp.getName();

	}

	@Query("select * from Employee  where age>18")
	public void findByage() {
		repositary.findAll();
	}
}
