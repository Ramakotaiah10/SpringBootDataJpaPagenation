package com.rama.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rama.employee.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {

}
