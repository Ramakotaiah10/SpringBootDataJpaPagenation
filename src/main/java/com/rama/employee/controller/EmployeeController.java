package com.rama.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rama.employee.service.EmployeeService;
import com.rama.employee.utils.PageDetails;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/getemployee")
	public String FetchEmployeesData(@RequestParam(value = "pageNumber", defaultValue = "0")Integer pagenumber, Model model) {

		PageDetails pageDetails = service.fetchAllEmployees(pagenumber, 4);
		
		model.addAttribute("pageDetails", pageDetails);
       return "listofemployees";
	}

}
