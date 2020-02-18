package com.iteriam.sanitas.calculator.factory;

import java.util.ArrayList;
import java.util.List;

import com.iteriam.sanitas.calculator.model.ExpresionTest;
import com.iteriam.sanitas.calculator.model.Operation;
import com.iteriam.sanitas.calculator.model.common.GeneralResponse;
import com.iteriam.sanitas.calculator.model.enums.OperatorEnum;

public class ExpresionFactory {
	
	public static ExpresionTest getBasicSumExpresion() {
		
		List<Operation> expresion = new ArrayList<>();
    	expresion.add(new Operation(1, 2, OperatorEnum.SUM));
    	Double result = (double) 3;
        GeneralResponse<Double> response = new GeneralResponse<Double>("OK", result);
        
        return new ExpresionTest(expresion, response);		
	}
	
	public static ExpresionTest getBasicSubstractionExpresion() {
		
		List<Operation> expresion = new ArrayList<>();
    	expresion.add(new Operation(2, 5, OperatorEnum.SUBSTRACTION));
    	Double result = (double) -3;
        GeneralResponse<Double> response = new GeneralResponse<Double>("OK", result);
        
        return new ExpresionTest(expresion, response);		
	}
	
	public static ExpresionTest getBasicDecimalSubstractionExpresion() {
		
		List<Operation> expresion = new ArrayList<>();
    	expresion.add(new Operation(2.1, -1, OperatorEnum.SUBSTRACTION));
    	Double result = (double) 3.1;
        GeneralResponse<Double> response = new GeneralResponse<Double>("OK", result);
        
        return new ExpresionTest(expresion, response);		
	}
	
}
