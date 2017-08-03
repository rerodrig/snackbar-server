package br.com.snackbar.server.service.discount;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class LightProductDiscountCalculatorTest {

	private final LightProductDiscountCalculator calculator = new LightProductDiscountCalculator();

	@Test
	public void shouldCalculateZeroDiscount() {

		int light = 5;
		int greasy = 1;
		BigDecimal totalPrice = BigDecimal.valueOf(9);

		assertEquals(BigDecimal.valueOf(0), this.calculator.calculate(light, greasy, totalPrice));
	}

	@Test
	public void shouldCalculateSomeDiscount() {

		int light = 1;
		int greasy = 0;
		BigDecimal totalPrice = BigDecimal.valueOf(9);

		assertEquals(BigDecimal.valueOf(0.9), this.calculator.calculate(light, greasy, totalPrice));
	}
}
