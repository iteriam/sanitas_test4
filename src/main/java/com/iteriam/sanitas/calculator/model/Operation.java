package com.iteriam.sanitas.calculator.model;

import com.iteriam.sanitas.calculator.model.enums.OperatorEnum;

import lombok.Getter;
import lombok.Setter;

public class Operation {
	
	public Operation(double number1, double number2, OperatorEnum operator) {
		this.number1 = number1;
		this.number2 = number2;
		this.operator = operator;
	}
	
	@Setter
	@Getter
	private double number1;
		
	@Setter
	@Getter
	private double number2;
	
	@Setter
	@Getter
	private OperatorEnum operator;
	
//	@Setter
//	@Getter
//	private OperatorEnum unionOperator;
//		
//	@Setter
//	@Getter
//	private List<Operation> nestedOperation;

}
