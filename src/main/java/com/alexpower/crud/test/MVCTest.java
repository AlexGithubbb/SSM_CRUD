package com.alexpower.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alexpower.crud.bean.Employee;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MVCTest {
	
	// import Springmvc ioc
	@Autowired	
	WebApplicationContext context;
	

	// mock mvc request
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();		
	}
	
	@Test
	public void testPage() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
		MockHttpServletRequest request = result.getRequest();
		PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("current page number: "+ pageInfo.getPageNum());
		System.out.println("total pages: " + pageInfo.getPages());
		System.out.println("total records: " + pageInfo.getTotal());
		
		
		
		int[] pages = pageInfo.getNavigatepageNums();
		for (int page : pages) {
			System.out.println(" " + page);		
		}
		
		// get employee info
		List<Employee> emps = pageInfo.getList();
		
		for (Employee employee : emps) {
			System.out.println("employee Id :" + employee.geteId() + ", employee name: " + employee.geteName());
		}								
		
	}
	

}
