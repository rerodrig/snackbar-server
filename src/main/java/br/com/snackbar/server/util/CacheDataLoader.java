package br.com.snackbar.server.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.model.Product;

@Component
public class CacheDataLoader {

	private static final String CACHE_INSTANCE_NAME = "snackbar";

	private final CacheManager cacheManager;

	@Autowired
	public CacheDataLoader(final CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public void loadSampleData() {
		this.loadProducts();
		this.loadIngredients();
	}

	private void loadIngredients() {
		JsonGenericDataLoader<Ingredient> ingredientDataLoader = new JsonGenericDataLoader<>(Ingredient.class,
				"data/ingredients.json");
		List<Ingredient> ingredients = ingredientDataLoader.loadData();
		this.cacheManager.getCache(CACHE_INSTANCE_NAME).put("ingredients", ingredients);
	}

	private void loadProducts() {
		JsonGenericDataLoader<Product> productDataLoader = new JsonGenericDataLoader<>(Product.class, "data/products.json");
		List<Product> products = productDataLoader.loadData();
		this.cacheManager.getCache(CACHE_INSTANCE_NAME).put("products", products);
	}

}
