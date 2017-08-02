package br.com.snackbar.server.service.price;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.snackbar.server.model.DiscountType;
import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.model.ProductItem;
import br.com.snackbar.server.service.discount.ExtraIngredientDiscountCalculator;
import br.com.snackbar.server.service.discount.LightProductDiscountCalculator;

public class ProductPriceCalculatorTest {

	@InjectMocks
	private ProductPriceCalculator priceCalculator;

	@Mock
	private ExtraIngredientDiscountCalculator extraCalculator;

	@Mock
	private LightProductDiscountCalculator lightCalculator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		when(this.lightCalculator.calculate(anyInt(), anyInt(), any(BigDecimal.class))).thenReturn(BigDecimal.ZERO);

		when(this.extraCalculator.calculate(anyObject(), anyInt())).thenReturn(BigDecimal.ZERO);

	}

	@Test
	public void shouldCalculateProductPrice() {

		Ingredient burger = new Ingredient(1, "Burger", BigDecimal.valueOf(4.25), DiscountType.GREASY);
		Ingredient lettuce = new Ingredient(1, "Lettuce", BigDecimal.valueOf(0.75), DiscountType.LIGHT);
		Ingredient bacon = new Ingredient(1, "Bacon", BigDecimal.valueOf(2.5), null);

		List<ProductItem> items = Arrays.asList(new ProductItem(bacon, 2), new ProductItem(lettuce, 1),
				new ProductItem(burger, 1));

		assertEquals(BigDecimal.valueOf(10).setScale(2), this.priceCalculator.calculate(items));
	}

}
