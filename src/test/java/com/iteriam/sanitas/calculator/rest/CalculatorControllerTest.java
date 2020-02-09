package com.iteriam.sanitas.calculator.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.iteriam.sanitas.calculator.service.OperationService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CalculatorControllerTest {
	
	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	protected OperationService operationService;

	@Before
	public void setUp() {
		Mockito.reset(operationService);
	}

	@Test
	public void shouldReturnFoundPost() throws Exception {
		// given
		String expresion = "0";
		Double result = new Double(0.0);

		// when
		when(operationService.calculate(expresion)).thenReturn(result);

		// then
		mockMvc.perform(get("/calculate/0").accept(MediaType.ALL))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("0.0"));

	}
}