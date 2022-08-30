package com.rama.employee.service;

import com.rama.employee.utils.PageDetails;

public interface EmployeeService {

	//Optional<EmployeeEntity> fetchEmployee(Integer empId);
	//EmployeeEntity saveEmployee(EmployeeEntity employee);
	//boolean deleteEmployee(Integer empId);
	  PageDetails fetchAllEmployees(Integer pageNumber,Integer pageSize);
	//List<EmployeeEntity> fetctEmpSortByName();
	//List<EmployeeEntity> fetctEmpSortBySalary();
	
	
}
