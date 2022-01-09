package com.codecool.feb2021pl.springdemo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class SpringDemoApplicationTests {

	@Test
	void contextLoads() {
		when(Employee.create("aaa")).thenReturn(new Employee("Jola"));

		System.out.println(Employee.create("aaa"));
	}

}
