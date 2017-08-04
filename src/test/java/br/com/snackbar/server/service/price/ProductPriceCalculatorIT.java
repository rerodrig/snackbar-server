package br.com.snackbar.server.service.price;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.snackbar.server.config.TestConfiguration;
import br.com.snackbar.server.model.DiscountType;
import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.model.ProductItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfiguration.class })
public class ProductPriceCalculatorIT {

	@Autowired
	private ProductPriceCalculator calculator;

	@Test
	public void test() {

		Ingredient lettuce = new Ingredient(1, "Lettuce", BigDecimal.valueOf(0.4), DiscountType.LIGHT);
		Ingredient burger = new Ingredient(3, "Burger", BigDecimal.valueOf(3.0), DiscountType.EXTRA_INGREDIENT);
		Ingredient cheese = new Ingredient(5, "Cheese", BigDecimal.valueOf(1.5), DiscountType.EXTRA_INGREDIENT);

		List<ProductItem> items = Arrays.asList(new ProductItem(cheese, 6), new ProductItem(burger, 18),
				new ProductItem(lettuce, 1));

		assertEquals(BigDecimal.valueOf(38.16), this.calculator.calculate(items));

	}
}
