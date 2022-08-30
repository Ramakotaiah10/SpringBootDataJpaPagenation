package com.rama.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


	private Integer empNo;	

    private String empName;

	private Double empSal;
	
	private String empEmail;

	private Integer empExperience;

	private String empDesignation;

}

