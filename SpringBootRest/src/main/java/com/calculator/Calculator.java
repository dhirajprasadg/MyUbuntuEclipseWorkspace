package com.calculator;

public class Calculator {

	public CalculatorService calservice;
	
	public Calculator(CalculatorService se){
		calservice=se;
	}
	
	public int addNumber(int i, int j){
		return i+j;
	}

	public int substractNumber(int i, int j){
		return calservice.substract(i,j);
	}
	
}
