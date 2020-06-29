package com.alexpower.crud.test;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alexpower.crud.bean.Department;
import com.alexpower.crud.bean.Employee;
import com.alexpower.crud.dao.DepartmentMapper;
import com.alexpower.crud.dao.EmployeeMapper;

/*
 * 
 * recommend use SpringTest modal
 * @ContextConfiguration
 * @Autowired
 * 
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	// spring mvc way
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	

	@Test
	public void testCRUD(){
		
//	    original way	
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		 DepartmentMapper departmentMapper = ac.getBean(DepartmentMapper.class);		 		 
		 */
		
		
//		 departmentMapper.insertSelective(new Department(null, "Test"));
//		 departmentMapper.insertSelective(new Department(null, "Dev"));
		
//		departmentMapper.deleteByPrimaryKey(1);
//		departmentMapper.insertSelective(new Department(null, "Test"));
//		departmentMapper.deleteByPrimaryKey(4);
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		
//		for (int i = 0; i < 100; i++) {
//			String uid = UUID.randomUUID().toString().substring(0,5)+i;
//			mapper.insertSelective(new Employee(null, uid , "M", uid+"@gmail.com", 3));
//		}
//		
//		mapper.deleteByPrimaryKey(101);
	
		
		List<Employee> list = employeeMapper.selectByExampleWithDept(null);
		for (Employee employee : list) {
			System.out.println(employee.geteId() + ": " + employee.geteName());
		}
		
		
		
		
		
		
		
		System.out.println(departmentMapper);
	}

}
