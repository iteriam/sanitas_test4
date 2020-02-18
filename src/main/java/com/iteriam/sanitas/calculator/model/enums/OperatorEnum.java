package com.iteriam.sanitas.calculator.model.enums;

import lombok.Getter;

@Getter
public enum OperatorEnum {
	
	SUM ("+"),
	SUBSTRACTION ("-");
	
	private String sign;
	
	private OperatorEnum(final String sign) {
		this.sign = sign;
	}	

}
