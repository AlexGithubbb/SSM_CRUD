package com.alexpower.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexpower.crud.bean.Employee;
import com.alexpower.crud.dao.EmployeeMapper;

public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		 return employeeMapper.selectByExampleWithDept(null);
	
	}

}
