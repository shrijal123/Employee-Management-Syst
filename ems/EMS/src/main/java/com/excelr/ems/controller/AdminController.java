package com.excelr.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.excelr.ems.model.Employee;
import com.excelr.ems.repository.EmployeeRepository;
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
    	 List<Employee> employeeList = employeeRepository.findAll(); // Fetch all employees
         model.addAttribute("ulist", employeeList);
        return "admindashboard";
    }
    
    @GetMapping("/addemployee")
    public String showAddEmployeePage() {
        return "addemployee";
    }
    
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute @Validated Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "addemployee";
        }
        employeeRepository.save(employee);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/edit/{employeeCode}")
    public String showEditEmployeePage(@PathVariable String employeeCode, Model model) {
        Employee employee = employeeRepository.findByEmployeeCode(employeeCode)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        model.addAttribute("employee", employee);
        return "editemployee"; // A form for editing an existing employee
    }
    

    @PostMapping("/update/{employeeCode}")
    public String updateEmployee(@PathVariable String employeeCode, 
                                  @ModelAttribute @Validated Employee employee, 
                                  BindingResult result, 
                                  RedirectAttributes redirectAttributes) {
    	System.out.println("Received employeeCode: " + employeeCode);
        if (result.hasErrors()) {
            return "editemployee"; // Return to edit page if there are validation errors
        }

        // Fetch the existing employee
        Optional<Employee> existingEmployeeOpt = employeeRepository.findByEmployeeCode(employeeCode);
        
        if (existingEmployeeOpt.isEmpty()) {
            // Redirect with an error message
            redirectAttributes.addFlashAttribute("errorMessage", "Employee not found");
            return "redirect:/admin/dashboard"; // Or redirect to an error page
        }

        Employee existingEmployee = existingEmployeeOpt.get();

        // Update fields as before...
        // Update fields
        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setCompanyEmail(employee.getCompanyEmail());
        existingEmployee.setPassword(employee.getPassword()); // Assuming you want to update password
        existingEmployee.setRole(employee.getRole()); // If role should be updated
        existingEmployee.setEnabled(employee.isEnabled()); // If enabled should be updated
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setAge(employee.getAge());

        // Current Address
        existingEmployee.setCurrentAddressLine1(employee.getCurrentAddressLine1());
        existingEmployee.setCurrentAddressLine2(employee.getCurrentAddressLine2());
        existingEmployee.setCurrentPincode(employee.getCurrentPincode());
        existingEmployee.setCurrentCity(employee.getCurrentCity());
        existingEmployee.setMobile(employee.getMobile());
        existingEmployee.setPersonalMail(employee.getPersonalMail());
        existingEmployee.setEmergencyContactMobile(employee.getEmergencyContactMobile());

        // Permanent Address
        existingEmployee.setPermanentAddressLine1(employee.getPermanentAddressLine1());
        existingEmployee.setPermanentAddressLine2(employee.getPermanentAddressLine2());
        existingEmployee.setPermanentPincode(employee.getPermanentPincode());
        existingEmployee.setPermanentCity(employee.getPermanentCity());

        // Office Address
        existingEmployee.setOfficeAddressLine1(employee.getOfficeAddressLine1());
        existingEmployee.setOfficeAddressLine2(employee.getOfficeAddressLine2());
        existingEmployee.setOfficePincode(employee.getOfficePincode());
        existingEmployee.setOfficeCity(employee.getOfficeCity());
        existingEmployee.setReportingManager(employee.getReportingManager());
        existingEmployee.setHrName(employee.getHrName());

        // Other fields
        existingEmployee.setDateOfJoining(employee.getDateOfJoining());
        existingEmployee.setEmployeeHistory(employee.getEmployeeHistory());
        existingEmployee.setStartDate(employee.getStartDate());
        existingEmployee.setEndDate(employee.getEndDate());
        existingEmployee.setProjectName(employee.getProjectName());
        existingEmployee.setProjectManager(employee.getProjectManager());

        // Finance Details
        existingEmployee.setPanCard(employee.getPanCard());
        existingEmployee.setAadharCard(employee.getAadharCard());
        existingEmployee.setBankName(employee.getBankName());
        existingEmployee.setBranchName(employee.getBranchName());
        existingEmployee.setIfscCode(employee.getIfscCode());
        existingEmployee.setCtcBreakup(employee.getCtcBreakup());

        // Save the updated employee
        employeeRepository.save(existingEmployee); 
        redirectAttributes.addFlashAttribute("successMessage", "Employee updated successfully");
        return "redirect:/admin/dashboard"; // Redirect to the admin dashboard after update
    }



    
    @GetMapping("/view/{employeeCode}")
    public String viewEmployee(@PathVariable String employeeCode, Model model) {
        Employee employee = employeeRepository.findByEmployeeCode(employeeCode)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        model.addAttribute("employee", employee);
        return "viewemployee"; // A view page for displaying employee details
    }

    @GetMapping("/delete/{employeeCode}")
    public String deleteEmployee(@PathVariable String employeeCode) {
        Employee employee = employeeRepository.findByEmployeeCode(employeeCode)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee); // Delete the employee by reference
        return "redirect:/admin/dashboard"; // Redirect to admin dashboard after deleting
    }
}