package com.iteriam.sanitas.calculator.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iteriam.sanitas.calculator.service.OperationService;

@Controller
@RestController
@RequestMapping(path = "/calculate")
public class CalculatorController {
	
	private final OperationService operationService;

	public CalculatorController(OperationService operationService) {
		this.operationService = operationService;
	}
	
	@GetMapping(value = "/{expresion}")
	@ResponseStatus(HttpStatus.OK)
	public double calculate(@PathVariable String expresion) {
		return operationService.calculate(expresion);
	}

}
