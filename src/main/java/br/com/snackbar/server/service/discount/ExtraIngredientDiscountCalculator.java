package br.com.snackbar.server.service.discount;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.snackbar.server.model.Ingredient;

@Component
public class ExtraIngredientDiscountCalculator {

	public BigDecimal calculate(final Ingredient ingredient, final Integer quantity) {

		Long qtyToDiscount = quantity / Long.valueOf(3);

		return BigDecimal.valueOf(qtyToDiscount).multiply(ingredient.getPrice());

	}

}
