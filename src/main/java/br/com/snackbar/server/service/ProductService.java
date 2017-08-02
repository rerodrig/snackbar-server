package br.com.snackbar.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.snackbar.server.dto.ProductItemDTO;
import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.model.Product;
import br.com.snackbar.server.model.ProductItem;
import br.com.snackbar.server.repository.IngredientRepository;
import br.com.snackbar.server.repository.ProductRepository;
import br.com.snackbar.server.service.price.ProductPriceCalculator;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IngredientRepository repository;

	@Autowired
	private ProductPriceCalculator calculator;

	public BigDecimal calculatePrice(final List<ProductItemDTO> items) {

		List<ProductItem> productItems = new ArrayList<>();

		for (ProductItemDTO item : items) {

			Ingredient ingredient = this.repository.find(item.getIngredientId());

			if (ingredient != null) {
				ProductItem productItem = new ProductItem(ingredient, item.getQuantity());
				productItems.add(productItem);
			}
		}

		return this.calculator.calculate(productItems);
	}

	public List<Product> list() {
		return this.productRepository.list();
	}

}
