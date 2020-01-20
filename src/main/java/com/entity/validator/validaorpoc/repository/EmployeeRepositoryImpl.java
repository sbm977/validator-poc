package com.entity.validator.validaorpoc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Repository;

import com.entity.validator.validaorpoc.entity.Employee;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
	

    @PersistenceContext
    EntityManager entityManager;


	/**
	 * Repository impl for updating/inserting an Employee if it passed entity validation 
	 * @param Employee
	 * @return List<String> with error message if any property fails validation
	 */
	@Override
	public List<String> updateEmployee(Employee emp){
		List<String> result = null;
		result = validateBeanEntity(emp);
		if(result.size() == 0){
			entityManager.merge(emp);
			entityManager.flush();
		}
		return result;
	}
	
	/**
	 * Validation Method that scan for any Constraint Violation either at attribute level or method annotated with AssertTrue
	 * @param emp
	 * @return List<String> with message and violation attribute/method name
	 */
	public List<String> validateBeanEntity(Employee emp){
		List<String> result = new ArrayList<String>();
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Employee>> errors = validator.validate(emp);
		 if(errors.size() > 0){
			 for(ConstraintViolation<Employee> e:errors ){
				 String errorMsg = e.getMessage()+"-Property Name:"+e.getPropertyPath().toString();
				 result.add(errorMsg);
			 }
		 }
		
		return result;
	}

}
