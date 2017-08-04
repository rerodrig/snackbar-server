package br.com.snackbar.server.service.discount;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.snackbar.server.model.DiscountType;
import br.com.snackbar.server.model.Ingredient;

public class ExtraIngredientDiscountCalculatorTest {

	private final ExtraIngredientDiscountCalculator calculator = new ExtraIngredientDiscountCalculator();

	@Test
	public void shouldDiscountOneItemInThree() {

		Ingredient ingredient = new Ingredient(1, "Burger", BigDecimal.valueOf(2.5), DiscountType.EXTRA_INGREDIENT);

		assertEquals(BigDecimal.valueOf(2.5), this.calculator.calculate(ingredient, 3));
	}

	@Test
	public void shouldDiscountTwoItemsInThree() {

		Ingredient ingredient = new Ingredient(1, "Burger", BigDecimal.valueOf(2.5), DiscountType.EXTRA_INGREDIENT);

		assertEquals(BigDecimal.valueOf(5.0), this.calculator.calculate(ingredient, 6));
	}

	@Test
	public void shouldDiscountFiveItemsInSixteen() {

		Ingredient ingredient = new Ingredient(1, "Burger", BigDecimal.valueOf(2.5), DiscountType.EXTRA_INGREDIENT);

		assertEquals(BigDecimal.valueOf(12.5), this.calculator.calculate(ingredient, 16));
	}

}
