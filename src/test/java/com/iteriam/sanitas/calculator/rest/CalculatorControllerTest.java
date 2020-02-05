package com.iteriam.sanitas.calculator.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class CalculatorControllerTest extends AbstractControllerTest {

	@Test
	public void shouldReturnFoundPost() throws Exception {
		// given
		String expresion = "0";
		Double result = new Double(0);

		// when
		when(operationService.calculate("0")).thenReturn(result);

		// then
		mockMvc.perform(get("/calculate/0").accept(MediaType.ALL))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("0.0"));

	}
}