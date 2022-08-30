package com.rama.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rama.employee.entity.EmployeeEntity;
import com.rama.employee.model.Employee;
import com.rama.employee.repository.EmployeeEntityRepository;
import com.rama.employee.utils.PageDetails;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeEntityRepository repo;
	
	public PageDetails fetchAllEmployees(Integer pageNumber, Integer pageSize) {
	
		Pageable pageble = PageRequest.of(pageNumber,pageSize);
		
		Page<EmployeeEntity> page = repo.findAll(pageble);
		
		int totalPages = page.getTotalPages();
	    
		long totalItems = page.getTotalElements();
		
		List<EmployeeEntity> lstEntity = page.getContent();
		
		List<Employee> lstEmp=new ArrayList<Employee>();
		
		lstEntity.forEach(entity ->
		{
			Employee emp=new Employee();
			
			BeanUtils.copyProperties(entity, emp);
			lstEmp.add(emp);
		});
		
		PageDetails pagedetails=new PageDetails();
		
		pagedetails.setLstemps(lstEmp);
		pagedetails.setCurrentPageNumber(page.getNumber());
		pagedetails.setNextPageExists(page.hasNext());
		pagedetails.setPreviousPageExists(page.hasPrevious());
		
		pagedetails.setTotalItems(totalItems);
		pagedetails.setTotalPages(totalPages);
	
		return pagedetails;
		
	}
	
}
