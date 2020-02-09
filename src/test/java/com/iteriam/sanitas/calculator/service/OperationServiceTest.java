package com.iteriam.sanitas.calculator.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationServiceTest {
	
	@Autowired
	OperationService operationService;

	@Test
	public void shouldReturnNotNull() {
		String expresion = "0";
		double result = 0.0;

		assertNotNull("Calculate shouldn't be null", expresion);
		assertThat(operationService.calculate(expresion), equalTo(result));
	}

	@Test
	public void shouldReturnNullForNullExpresion() {
//		String expresion = "0";
//		String result = "0";
//
//		assertNotNull("Calculate shouldn't be null", expresion);
//		assertThat(operationService.calculate(expresion), equalTo(result));	
	}
	
	@Test
	public void shouldReturnResultForBasicSum() {
		String expresion = "1+1";
		double result = 2.0;

		assertThat(operationService.calculate(expresion), equalTo(result));
	}
	
	@Test
	public void shouldReturnResultForBasicSubtration() {
		String expresion = "2-1";
		double result = 1.0;

		assertThat(operationService.calculate(expresion), equalTo(result));
	}
	
	@Test
	public void shouldReturnResultForBasicDecimalSubtration() {
		String expresion = "2.1-1";
		double result = 1.1;

		assertThat(operationService.calculate(expresion), equalTo(result));
	}

}
