package com.iteriam.sanitas.calculator.rest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iteriam.sanitas.calculator.factory.ExpresionFactory;
import com.iteriam.sanitas.calculator.model.ExpresionTest;
import com.iteriam.sanitas.calculator.service.OperationService;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
	
    @InjectMocks
    private CalculatorController controller;
    
    @Mock
    private OperationService operationService;
    
//    @Autowired
//    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() {
    	Mockito.reset(operationService);    	
    }

    @Test
    public void testOperationSum() {    	
    	ExpresionTest expresionTest = ExpresionFactory.getBasicSumExpresion();
        Mockito.when(operationService.calculate(expresionTest.getExpresion())).thenReturn(expresionTest.getResponse());
        assertEquals(expresionTest.getResponse().getResult(), operationService.calculate(expresionTest.getExpresion()).getResult());
    }

    @Test
    public void testOperationSubtration() {    	
    	ExpresionTest expresionTest = ExpresionFactory.getBasicSubstractionExpresion();    	
        Mockito.when(operationService.calculate(expresionTest.getExpresion())).thenReturn(expresionTest.getResponse());
        assertEquals(expresionTest.getResponse().getResult(), operationService.calculate(expresionTest.getExpresion()).getResult());
    }	

}