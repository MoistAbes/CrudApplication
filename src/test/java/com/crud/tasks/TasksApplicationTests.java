package com.crud.tasks;

import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;

@SpringBootTest
class TasksApplicationTests {


//	@Test
//	void testContext() {
//		//Given
//		ApplicationContext context =
//				new AnnotationConfigApplicationContext("com.crud.tasks.controller");
//
//		//When & Then
//		System.out.println("===== Beans list: ==== >>");
//		Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
//		System.out.println("<< ===== Beans list ====");
//	}


	@Test
	void contextLoads() {
	}

}
