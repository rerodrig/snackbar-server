package br.com.snackbar.server.service.price;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.model.ProductItem;
import br.com.snackbar.server.service.discount.ExtraIngredientDiscountCalculator;
import br.com.snackbar.server.service.discount.LightProductDiscountCalculator;

@Component
public class ProductPriceCalculator {

	@Autowired
	private ExtraIngredientDiscountCalculator extraCalculator;

	@Autowired
	private LightProductDiscountCalculator lightCalculator;

	public BigDecimal calculate(final List<ProductItem> items) {

		BigDecimal totalPrice = BigDecimal.ZERO;
		BigDecimal itemsDiscount = BigDecimal.ZERO;

		int lightQty = 0;
		int greasyQty = 0;

		for (ProductItem item : items) {

			Ingredient ingredient = item.getIngredient();

			if (ingredient.getDiscountType() != null) {
				switch (ingredient.getDiscountType()) {
				case EXTRA_INGREDIENT:
					itemsDiscount = itemsDiscount.add(this.extraCalculator.calculate(ingredient, item.getQuantity()));
					break;
				case LIGHT:
					lightQty++;
					break;
				case GREASY:
					greasyQty++;
					break;
				default:
					break;
				}
			}

			BigDecimal itemPrice = ingredient.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
			totalPrice = totalPrice.add(itemPrice);

		}

		totalPrice = totalPrice.subtract(itemsDiscount);

		BigDecimal lightDiscount = this.lightCalculator.calculate(lightQty, greasyQty, totalPrice);

		return totalPrice.subtract(lightDiscount);
	}

}
