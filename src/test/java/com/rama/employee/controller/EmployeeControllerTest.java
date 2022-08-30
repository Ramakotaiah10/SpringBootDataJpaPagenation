package com.rama.employee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;

import com.rama.employee.model.Employee;
import com.rama.employee.service.EmployeeService;
import com.rama.employee.utils.PageDetails;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@MockBean
	private EmployeeService empService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void list_ReturnsViewWithRecords_WhenStudentListViewIsAccessed() throws Exception {

		final int pageNumber = 0;
		final int pageSize = 1;
		final int totalPages = 3;

		final List<Employee> emploees = Arrays.asList(
				new Employee(101, "rama", 5000.0, "ram12@gmail.com", 6, "pro"),
				new Employee(102, "bhanu", 4500.0, "bhanu12@gmail.com", 5, "uat"),
				new Employee(103, "ajay", 5500.0, "ajay12@gmail.com", 3, "qa"),
				new Employee(104, "vijay", 6500.0, "vijay12@gmail.com", 7, "dev"));

		//final Pageable page = PageRequest.of(pageNumber, pageSize);
		
		PageDetails pageDetails=new PageDetails(pageNumber, totalPages, emploees);

		//final Page<Employee> response = new PageImpl<>(emploees, page, totalPages);

		when(empService.fetchAllEmployees(pageNumber, pageSize)).thenReturn(pageDetails);
	        
	        MockHttpServletRequestBuilder param = MockMvcRequestBuilders.get("/employee/getemployee")
	        		               			.param("page", String.valueOf(pageNumber))
	        		               			.param("size", String.valueOf(pageSize));
	        ResultActions perform = mockMvc.perform(param);
	        
	        MvcResult results = perform.andReturn();
	        MockHttpServletResponse response2 = results.getResponse();
	        int status2 = response2.getStatus();
	        
	        assertEquals(200, status2);
	  }
}
