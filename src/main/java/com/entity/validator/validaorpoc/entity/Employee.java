package com.entity.validator.validaorpoc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 1, max = 10, message="Invalid Name length")
	private String name;
	
	@Size(min = 0, max = 30, message="Invalid Email address")
	@Column(name = "email_address")
	private String email;
	public Employee() {
	}
	public Employee(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Transient
	@JsonIgnore
	@AssertTrue(message = "First Name should appear in email address")
	public boolean isValid(){
		boolean result = true;
		
		String[]  splitName = getName().split(" ");
		result = getEmail().contains(splitName[0]);
		
		return result;
	}
	
}