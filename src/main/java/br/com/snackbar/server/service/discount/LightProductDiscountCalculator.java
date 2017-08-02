package br.com.snackbar.server.service.discount;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class LightProductDiscountCalculator {

	public BigDecimal calculate(final int lightQty, final int greasyQty, final BigDecimal totalPrice) {

		BigDecimal discountPercentage = BigDecimal.ZERO;

		if (lightQty > 0 && greasyQty == 0) {
			discountPercentage = BigDecimal.valueOf(0.1);
		}

		return totalPrice.multiply(discountPercentage);

	}

}
