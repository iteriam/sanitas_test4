package com.iteriam.sanitas.calculator.util;

public class TraceBuilder {
	
	public static String createTrace(String message, Object objectTrace) {
		return message + (objectTrace == null ? "response NULL " : objectTrace.toString());		
	}
	

}
