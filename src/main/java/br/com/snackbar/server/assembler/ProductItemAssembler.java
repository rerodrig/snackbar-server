package br.com.snackbar.server.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.snackbar.server.dto.ProductItemDTO;
import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.model.ProductItem;
import br.com.snackbar.server.repository.IngredientRepository;

@Component
public class ProductItemAssembler {

	@Autowired
	private IngredientRepository ingredientRepository;

	public List<ProductItem> toModelList(final List<ProductItemDTO> items) {

		List<ProductItem> productItems = new ArrayList<>();

		items.stream().forEach(i -> productItems.add(this.toModel(i)));

		return productItems;

	}

	private ProductItem toModel(final ProductItemDTO item) {

		Ingredient ingredient = this.ingredientRepository.find(item.getIngredientId());

		if (ingredient != null) {
			return new ProductItem(ingredient, item.getQuantity());
		}

		return null;

	}
}
