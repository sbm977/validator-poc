package com.entity.validator.validaorpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.validator.validaorpoc.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {
	Employee findByName(String name);
	Employee findByEmail(String email);
}
