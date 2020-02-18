package com.iteriam.sanitas.calculator.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.stereotype.Service;

import com.iteriam.sanitas.calculator.model.Operation;
import com.iteriam.sanitas.calculator.model.common.GeneralResponse;
import com.iteriam.sanitas.calculator.model.enums.OperatorEnum;

@Service
public class OperationService {
	
	public OperationService() {
		
	}

	public GeneralResponse<Double> calculate(List<Operation> expresion) {
		
		if (expresion == null) {
			return new GeneralResponse<Double>("Por favor valide el request enviado", null);
		}else if (expresion.isEmpty()) {
			return new GeneralResponse<Double>("No se realizó ninguna operación", null);	
		}		
		
		return new GeneralResponse<Double>("OK", execute(expresion));
	}
	
	private double execute(List<Operation> operations) {
		
		AtomicReference<Double> result = new AtomicReference<>();
		result.set((double) 0);
		
		operations.stream().forEach( (operation) -> {				
				result.set(
						operate(operation.getNumber1(), operation.getNumber2(), operation.getOperator() ) 
						);
			});
		return result.get();
	}
	
	private double operate(double result, double number, OperatorEnum operator) {
		
		switch (operator.getSign()) {
		case "+":
			result += number;
			break;
		case "-":
			result -= number;
			break;
		default:
			break;
		}		
		return result;
	}

}
