package com.iteriam.sanitas.calculator.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.iteriam.sanitas.calculator.model.common.GeneralResponse;
import com.iteriam.sanitas.calculator.service.OperationService;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
	
    @InjectMocks
    private CalculatorController controller;
    
    @Mock
    private OperationService operationService;
    
    @Autowired
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() {
    	Mockito.reset(operationService);    	
    }

    @Test
    public void testSum() {
    	String expresion = "1+1";
    	Double result = (double) 2;
        GeneralResponse<Double> response = new GeneralResponse<Double>("OK", result);
    	
        Mockito.when(operationService.calculate(expresion)).thenReturn(response);
        assertEquals(controller.calculate(expresion).getResult(), new Double(result));
    }

    @Test
    public void testSubtration() {
    	String expresion = "2-1";
    	Double result = (double) 1;
        GeneralResponse<Double> response = new GeneralResponse<Double>("OK", result);
    	
        Mockito.when(operationService.calculate(expresion)).thenReturn(response);
        assertEquals(controller.calculate(expresion).getResult(), new Double(result));        
    }	

}