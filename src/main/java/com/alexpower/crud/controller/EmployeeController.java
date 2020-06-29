package com.alexpower.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexpower.crud.bean.Employee;
import com.alexpower.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/emps")
	public  String getEmps(@RequestParam(value = "pn", defaultValue = "1")Integer pn, Model model) {
		// introduce pageHelper jar
		PageHelper.startPage(pn, 5);  // the page number and the size of each page
		//分页查询
		List<Employee> emps  = employeeService.getAll();
		// all we need to do is send pageinfo to client side
		// it also mantains the detailed info comes from the db
		PageInfo page = new PageInfo(emps,5);			
		
		model.addAttribute("pageInfo", page);
		
		return "list";
	}

}
