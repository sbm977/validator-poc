package com.entity.validator.validaorpoc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.validator.validaorpoc.entity.Employee;

/**
 * Custom Repository Class to create Update Employee 
 * @author shubh
 *
 */

public interface EmployeeRepositoryCustom {

	public List<String> updateEmployee(Employee emp);

}
