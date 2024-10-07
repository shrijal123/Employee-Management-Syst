package com.excelr.ems.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.ems.model.Employee;
import com.excelr.ems.repository.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
    private EmployeeRepository employeeRepository;

	@GetMapping("/dashboard")
	public String employeeDashboard(Principal principal, Model model) {
	    // Assuming principal.getName() returns the employee code
	    String employeeCode = principal.getName();
	    
	    // Fetch the specific employee based on the employeeCode
	    Employee employee = employeeRepository.findByEmployeeCode(employeeCode)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    model.addAttribute("employee", employee); // Add the specific employee to the model
	    return "employeedashboard"; // Return the view name
	}

}
