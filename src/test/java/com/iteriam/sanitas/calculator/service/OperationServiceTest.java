package com.iteriam.sanitas.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.sanitas.calculator.model.common.GeneralResponse;

@SpringBootTest(classes=OperationService.class)
public class OperationServiceTest {
	
	@Autowired
	OperationService operationService;

	@Test
	public void shouldReturnNotNull() {
		String expresion = "0";
		double result = 0.0;
		
		GeneralResponse<Double> response = operationService.calculate(expresion);
		assertEquals(result, response.getResult());
	}
	
	@Test
	public void shouldReturnResultForBasicSum() {
		String expresion = "1+1";
		double result = 2.0;
		
		GeneralResponse<Double> response = operationService.calculate(expresion);
		assertEquals(result, response.getResult());		
	}
	
	@Test
	public void shouldReturnResultForBasicSubtration() {
		String expresion = "2-1";
		double result = 1.0;

		GeneralResponse<Double> response = operationService.calculate(expresion);
		assertEquals(result, response.getResult());
	}
	
	@Test
	public void shouldReturnResultForBasicDecimalSubtration() {
		String expresion = "2.1-1";
		double result = 1.1;
		
		GeneralResponse<Double> response = operationService.calculate(expresion);
		assertEquals(result, response.getResult());
	}

}
