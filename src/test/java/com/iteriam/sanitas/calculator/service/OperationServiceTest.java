package com.iteriam.sanitas.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.sanitas.calculator.factory.ExpresionFactory;
import com.iteriam.sanitas.calculator.model.ExpresionTest;
import com.iteriam.sanitas.calculator.model.Operation;
import com.iteriam.sanitas.calculator.model.common.GeneralResponse;

@SpringBootTest(classes=OperationService.class)
public class OperationServiceTest {
	
	@Autowired
	OperationService operationService;
	
	@Test
	public void shouldReturnResultNull() {
		ExpresionTest expresionTest = new ExpresionTest(null, new GeneralResponse<Double>(null, null));
		GeneralResponse<Double> response = operationService.calculate(expresionTest.getExpresion());
		assertEquals(expresionTest.getResponse().getResult(), response.getResult());
	}
	
	@Test
	public void shouldReturnResultNullFromListOperationEmpty() {
		List<Operation> expresion = new ArrayList<Operation>();
		ExpresionTest expresionTest = new ExpresionTest(expresion, new GeneralResponse<Double>(null, null));
		GeneralResponse<Double> response = operationService.calculate(expresionTest.getExpresion());
		assertEquals(expresionTest.getResponse().getResult(), response.getResult());
	}

	@Test
	public void shouldReturnResultForBasicSum() {
		ExpresionTest expresionTest = ExpresionFactory.getBasicSumExpresion();
		GeneralResponse<Double> response = operationService.calculate(expresionTest.getExpresion());
		assertEquals(expresionTest.getResponse().getResult(), response.getResult().doubleValue());
	}
	
	@Test
	public void shouldReturnResultForBasicSubtration() {
		ExpresionTest expresionTest = ExpresionFactory.getBasicSubstractionExpresion();
		GeneralResponse<Double> response = operationService.calculate(expresionTest.getExpresion());
		assertEquals(expresionTest.getResponse().getResult(), response.getResult().doubleValue());
	}
	
	@Test
	public void shouldReturnResultForBasicDecimalSubtration() {
		ExpresionTest expresionTest = ExpresionFactory.getBasicDecimalSubstractionExpresion();
		GeneralResponse<Double> response = operationService.calculate(expresionTest.getExpresion());
		assertEquals(expresionTest.getResponse().getResult(), response.getResult().doubleValue());
	}

}
