package com.rama.employee.utils;

import java.util.List;

import com.rama.employee.model.Employee;

import lombok.Data;

@Data
public class PageDetails  {

	List<Employee> lstemps;
	Integer currentPageNumber;
	int totalPages;
    long totalItems;
	boolean isNextPageExists;
	boolean isPreviousPageExists;
	
	public PageDetails(Integer currentPageNumber, int totalPages, List<Employee> lstemps) {
		super();
		this.currentPageNumber = currentPageNumber;
		this.totalPages = totalPages;
		this.lstemps = lstemps;
	}

	public PageDetails() {
		
	}
	
	
}
