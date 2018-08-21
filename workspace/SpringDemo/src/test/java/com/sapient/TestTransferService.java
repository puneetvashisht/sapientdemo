package com.sapient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestTransferService {

	@Autowired
	TransferService service;
	
	@Autowired
	CourseService courseService;
//	private static ApplicationContext context;
//
//	@BeforeClass
//	public static void setUp() throws Exception {
//		context = new ClassPathXmlApplicationContext("beans.xml");
//	}

//	@Test
	public void test() {
		
//		TransferService service = context.getBean(TransferService.class);
		service.transfer(123l, 3454, 34535.33);
	}
	
	@Test
	public void testFindCourses(){
		courseService.findCourses();
	}
	
	

}
