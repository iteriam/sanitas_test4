package com.iteriam.sanitas.calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.iteriam.sanitas.calculator.model.common.GeneralResponse;

@Service
public class OperationService {
	
	private static String NUMBERS_REGEX = "[^\\\\+\\\\/\\\\*\\\\-]";
	private static String OPERATORS_REGEX = "[\\+\\/\\*\\-]";
	
	public OperationService() {
		
	}

	public GeneralResponse<Double> calculate(String expresion) {
		
		String cleanExpresion = expresion.replace(",", ".").trim().replaceAll("^\\s*","");
		
		List<Double> numbers = getNumbers(cleanExpresion);
		List<String> operators = getOperators(cleanExpresion);
		
		if (numbers == null) {
			return new GeneralResponse<Double>("Por favor valide los números ingresados", null);
		}else if (numbers.size() < 2) {
			return new GeneralResponse<Double>("No se realizó ninguna operación", numbers.get(0));	
		}else if (operators == null || operators.size() < 1) {
			return new GeneralResponse<Double>("Por favor valide los operadores ingresados", null);
		}		
		
		return new GeneralResponse<Double>("Ejecución operación exitosa", execute(numbers, operators));
	}
	
	private double execute(List<Double> numbers, List<String>operators) {
		
		AtomicReference<Double> result = new AtomicReference<>();
		result.set(numbers.get(0));
		AtomicInteger indexOperators = new AtomicInteger(0);
		numbers.stream().skip(1).forEach( (number) -> {				
				result.set(operate(result.get(), number, operators.get(indexOperators.getAndIncrement())));
			});
		return result.get();
	}
	
	private double operate(double result, double number, String operator) {
		
		switch (operator) {
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
	
	
	private List<Double> getNumbers(String expresion){
		
		List<Double> numbers = null;
		
		numbers = Arrays.stream(expresion.split(OPERATORS_REGEX))
				.map(Double::parseDouble)
		        .collect(Collectors.toList());
		
		return numbers;		
	}
	
	private List<String> getOperators(String expresion){
		
		List<String> operators = null;
				
		operators = Arrays.stream(expresion.split(NUMBERS_REGEX))
				.filter(str -> !str.isEmpty())
				.collect(Collectors.toList());
		
		return operators;
	}

}
