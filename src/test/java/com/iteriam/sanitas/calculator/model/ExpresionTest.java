package com.iteriam.sanitas.calculator.model;

import java.util.List;

import com.iteriam.sanitas.calculator.model.common.GeneralResponse;

import lombok.Getter;
import lombok.Setter;

public class ExpresionTest {
	
	public ExpresionTest(List<Operation> expresion, GeneralResponse<Double> response) {
		this.expresion = expresion;
		this.response = response;
	}

	@Setter
	@Getter
	List<Operation> expresion;
	
	@Setter
	@Getter
	GeneralResponse<Double> response;

}
