package com.example.Employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.model.Credentials;
import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;

@RestController
public class LoginController {
	@Autowired
	EmployeeService service;

	@PostMapping(value = "/login")
	public String postLogin(@RequestBody Credentials cred, Model model, HttpSession session) {

		if (service.checkEmployee(cred)) {

			model.addAttribute("currentUser", cred.getName());
			session.setAttribute("userId", cred.getId());
			return "login Successful";
		}
		return "login failed";
	}

	@PostMapping(value = "/employee")
	public String createEmployee(@RequestBody Employee emp) {

		String name = service.createEmployee(emp);
		return name + " created successfully";

	}

	@GetMapping(value = "/employess")
	public void getEmpDetails() {
		service.findByage();

	}
}
