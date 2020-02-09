package com.iteriam.sanitas.calculator.model.common;

import lombok.Getter;
import lombok.Setter;

public class GeneralResponse<T> {
	
	@Setter
	@Getter
	String message;
	
	@Setter
	@Getter
	T result;
	
	public GeneralResponse(String message, T result) {
		this.message = message;
		this.result = result;
	}

}
