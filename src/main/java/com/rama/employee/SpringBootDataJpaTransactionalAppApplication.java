package com.rama.employee;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.rama.employee.entity.EmployeeEntity;
import com.rama.employee.repository.EmployeeEntityRepository;

@SpringBootApplication
public class SpringBootDataJpaTransactionalAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDataJpaTransactionalAppApplication.class, args);
		
		EmployeeEntityRepository repository = context.getBean(EmployeeEntityRepository.class);
		
		int pageNo=0;
		int pageSize=3;
		
		PageRequest pagerequest = PageRequest.of(pageNo, pageSize, Sort.by("empExperience"));
		
		Page<EmployeeEntity> pageData = repository.findAll(pagerequest);
		
		System.out.println("Total Pages "+pageData.getTotalPages());
		List<EmployeeEntity> content = pageData.getContent();
		
		content.forEach(System.out::println);
		
		
		
		
		
		
		
				
				
	}

}
