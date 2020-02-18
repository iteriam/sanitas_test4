package com.iteriam.sanitas.calculator.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iteriam.sanitas.calculator.model.common.GeneralResponse;
import com.iteriam.sanitas.calculator.service.OperationService;
import com.iteriam.sanitas.calculator.util.TraceBuilder;

import io.corp.calculator.TracerImpl;

@Controller
@RestController
@RequestMapping(path = "/calculate")
public class CalculatorController {
	
	private static TracerImpl trace = new TracerImpl();
	private final OperationService operationService;

	public CalculatorController(OperationService operationService) {
		this.operationService = operationService;
	}
	
	/**
     * Calcula la expresión matemática enviada como un string
     *
     * @return Resultado de la ejecución del calculo sobre la expresión en una estructura GeneralResponse
     */
	@GetMapping(value = "/{expresion}")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<Double> calculate(@PathVariable String expresion) {
		GeneralResponse<Double> result = operationService.calculate(expresion);
		trace.trace(TraceBuilder.createTrace("expresión: {"+expresion+"}, response:", result));
		return result;
	}
	
	
	
	

}
