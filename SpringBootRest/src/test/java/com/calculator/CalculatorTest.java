package com.calculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CalculatorTest {
	Calculator cal;
	// Using Mockito framework to mock ie create fack object of
	// calculatorservice interface
	// CalculatorService calser = mock(CalculatorService.class);

	@Rule
	public MockitoRule moc = MockitoJUnit.rule();
	@Mock
	CalculatorService calser;
	
	@Before
	public void setup() {
		cal = new Calculator(calser);
		System.out.println(" Object for test class Calculator created ");
		
	}

	@Test
	public void testAddNumber() {
		assertEquals(7, cal.addNumber(4, 3));
	}

	@Test
	public void testSubstractNumber() {
		when(calser.substract(4, 3)).thenReturn(1);
		assertEquals(1, cal.substractNumber(4, 3));
		verify(calser).substract(4, 3);

	}

}
