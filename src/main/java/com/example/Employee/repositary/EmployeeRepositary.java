package com.example.Employee.repositary;

import org.springframework.data.repository.CrudRepository;

import com.example.Employee.model.Employee;

public interface EmployeeRepositary extends CrudRepository<Employee, Integer> {

}
