package com.excelr.ems.repository;

import com.excelr.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmployeeCodeOrCompanyEmail(String employeeCode, String companyEmail);

	Optional<Employee> findByEmployeeCode(String employeeCode);
	
}
