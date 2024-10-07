package com.excelr.ems.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee") 
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String employeeCode;   //Present

    @Column(nullable = false)
    private String fullName; //Present

    @Column(unique = true, nullable = false)
    private String companyEmail;  //Present

    @Column(nullable = false)
    private String password;      //Present

    @Column(nullable = false)
    private String role = "EMPLOYEE";  // Default to EMPLOYEE //Present

    @Column(nullable = false)
    private boolean enabled = true;  // Default to true, meaning account is enabled //Present

    @Column(nullable = false)
    private LocalDate dateOfBirth; //Present

    @Column(nullable = false)
    private String gender; //Present

    @Column(nullable = false)
    private int age; //Present

    // Current Address
    @Column(nullable = false)
    private String currentAddressLine1; //Present

    @Column(nullable = false)
    private String currentAddressLine2; //Present

    @Column(nullable = false)
    private String currentPincode;  //Present

    @Column(nullable = false)
    private String currentCity;  //Present

    @Column(nullable = false)
    private String mobile;   //Present

    @Column(nullable = false)
    private String personalMail;  //Present

    @Column(nullable = false)
    private String emergencyContactMobile; //Present

    // Permanent Address
    @Column(nullable = false)
    private String permanentAddressLine1;  //Present

    @Column(nullable = false)
    private String permanentAddressLine2;  //Present

    @Column(nullable = false)
    private String permanentPincode;   //Present

    @Column(nullable = false)
    private String permanentCity;   //Present

    // Office Address
    @Column(nullable = false)
    private String officeAddressLine1;  //Present
    
    @Column(nullable = false)
    private String officeAddressLine2;   //Present
    
    @Column(nullable = false)
    private String officePincode;  //Present
    
    @Column(nullable = false)
    private String officeCity;  //Present

    @Column(nullable = false)
    private String reportingManager;  //Present

    @Column(nullable = false)
    private String hrName;  //Present

    @Column(nullable = false)
    private LocalDate dateOfJoining;  //Present

    @Column(nullable = false)
    private String employeeHistory;  //Present

    // Project Details
    @Column(nullable = false)
    private LocalDate startDate;  //Present

    @Column(nullable = false)
    private LocalDate endDate;  //Present

    @Column(nullable = false)
    private String projectName;  //Present

    @Column(nullable = false)
    private String projectManager;  //Present

    // Finance Details
    @Column(nullable = false)
    private String panCard;  //Present

    @Column(nullable = false)
    private String aadharCard;  //Present

    @Column(nullable = false)
    private String bankName;  //Present

    @Column(nullable = false)
    private String branchName;  //Present

    @Column(nullable = false)
    private String ifscCode;  //Present

    @Column(nullable = false)
    private String ctcBreakup;  //Present

    // Default constructor
    public Employee() {
        // No need to set the role again, it's already initialized
    }

    public Employee(Long id, String employeeCode, String fullName, String companyEmail, String password, String role,
			boolean enabled, LocalDate dateOfBirth, String gender, int age, String currentAddressLine1,
			String currentAddressLine2, String currentPincode, String currentCity, String mobile, String personalMail,
			String emergencyContactMobile, String permanentAddressLine1, String permanentAddressLine2,
			String permanentPincode, String permanentCity, String officeAddressLine1, String officeAddressLine2, String officePincode, String officeCity, String reportingManager, String hrName,
			LocalDate dateOfJoining, String employeeHistory, LocalDate startDate, LocalDate endDate, String projectName,
			String projectManager, String panCard, String aadharCard, String bankName, String branchName,
			String ifscCode, String ctcBreakup) {
		this.id = id;
		this.employeeCode = employeeCode;
		this.fullName = fullName;
		this.companyEmail = companyEmail;
		this.password = password;
		this.role = role != null ? role : "EMPLOYEE"; ;
		this.enabled = enabled;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.age = age;
		this.currentAddressLine1 = currentAddressLine1;
		this.currentAddressLine2 = currentAddressLine2;
		this.currentPincode = currentPincode;
		this.currentCity = currentCity;
		this.mobile = mobile;
		this.personalMail = personalMail;
		this.emergencyContactMobile = emergencyContactMobile;
		this.permanentAddressLine1 = permanentAddressLine1;
		this.permanentAddressLine2 = permanentAddressLine2;
		this.permanentPincode = permanentPincode;
		this.permanentCity = permanentCity;
		this.officeAddressLine1 = officeAddressLine1;
		this.officeAddressLine2 = officeAddressLine2;
		this.officePincode = officePincode;
		this.officeCity = officeCity;
		this.reportingManager = reportingManager;
		this.hrName = hrName;
		this.dateOfJoining = dateOfJoining;
		this.employeeHistory = employeeHistory;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectName = projectName;
		this.projectManager = projectManager;
		this.panCard = panCard;
		this.aadharCard = aadharCard;
		this.bankName = bankName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.ctcBreakup = ctcBreakup;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurrentAddressLine1() {
        return currentAddressLine1;
    }

    public void setCurrentAddressLine1(String currentAddressLine1) {
        this.currentAddressLine1 = currentAddressLine1;
    }

    public String getCurrentAddressLine2() {
        return currentAddressLine2;
    }

    public void setCurrentAddressLine2(String currentAddressLine2) {
        this.currentAddressLine2 = currentAddressLine2;
    }

    public String getCurrentPincode() {
        return currentPincode;
    }

    public void setCurrentPincode(String currentPincode) {
        this.currentPincode = currentPincode;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPersonalMail() {
        return personalMail;
    }

    public void setPersonalMail(String personalMail) {
        this.personalMail = personalMail;
    }

    public String getEmergencyContactMobile() {
        return emergencyContactMobile;
    }

    public void setEmergencyContactMobile(String emergencyContactMobile) {
        this.emergencyContactMobile = emergencyContactMobile;
    }

    public String getPermanentAddressLine1() {
        return permanentAddressLine1;
    }

    public void setPermanentAddressLine1(String permanentAddressLine1) {
        this.permanentAddressLine1 = permanentAddressLine1;
    }

    public String getPermanentAddressLine2() {
        return permanentAddressLine2;
    }

    public void setPermanentAddressLine2(String permanentAddressLine2) {
        this.permanentAddressLine2 = permanentAddressLine2;
    }

    public String getPermanentPincode() {
        return permanentPincode;
    }

    public void setPermanentPincode(String permanentPincode) {
        this.permanentPincode = permanentPincode;
    }

    public String getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }

    public String getOfficeAddressLine1() {
		return officeAddressLine1;
	}

	public void setOfficeAddressLine1(String officeAddressLine1) {
		this.officeAddressLine1 = officeAddressLine1;
	}

	public String getOfficeAddressLine2() {
		return officeAddressLine2;
	}

	public void setOfficeAddressLine2(String officeAddressLine2) {
		this.officeAddressLine2 = officeAddressLine2;
	}

	public String getOfficePincode() {
		return officePincode;
	}

	public void setOfficePincode(String officePincode) {
		this.officePincode = officePincode;
	}

	public String getOfficeCity() {
		return officeCity;
	}

	public void setOfficeCity(String officeCity) {
		this.officeCity = officeCity;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmployeeHistory() {
        return employeeHistory;
    }

    public void setEmployeeHistory(String employeeHistory) {
        this.employeeHistory = employeeHistory;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getCtcBreakup() {
        return ctcBreakup;
    }

    public void setCtcBreakup(String ctcBreakup) {
        this.ctcBreakup = ctcBreakup;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeCode=" + employeeCode + ", fullName=" + fullName + ", companyEmail="
				+ companyEmail + ", password=" + password + ", role=" + role + ", enabled=" + enabled + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", age=" + age + ", currentAddressLine1=" + currentAddressLine1
				+ ", currentAddressLine2=" + currentAddressLine2 + ", currentPincode=" + currentPincode
				+ ", currentCity=" + currentCity + ", mobile=" + mobile + ", personalMail=" + personalMail
				+ ", emergencyContactMobile=" + emergencyContactMobile + ", permanentAddressLine1="
				+ permanentAddressLine1 + ", permanentAddressLine2=" + permanentAddressLine2 + ", permanentPincode="
				+ permanentPincode + ", permanentCity=" + permanentCity + ", officeAddressLine1=" + officeAddressLine1
				+ ", officeAddressLine2=" + officeAddressLine2 + ", officePincode=" + officePincode + ", officeCity="
				+ officeCity + ", reportingManager=" + reportingManager + ", hrName=" + hrName + ", dateOfJoining="
				+ dateOfJoining + ", employeeHistory=" + employeeHistory + ", startDate=" + startDate + ", endDate="
				+ endDate + ", projectName=" + projectName + ", projectManager=" + projectManager + ", panCard="
				+ panCard + ", aadharCard=" + aadharCard + ", bankName=" + bankName + ", branchName=" + branchName
				+ ", ifscCode=" + ifscCode + ", ctcBreakup=" + ctcBreakup + "]";
	}

}
