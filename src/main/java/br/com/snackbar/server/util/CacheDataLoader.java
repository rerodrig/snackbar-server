package br.com.snackbar.server.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.model.Product;

@Component
public class CacheDataLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(CacheDataLoader.class);

	private static final String CACHE_INSTANCE_NAME = "snackbar";

	private final CacheManager cacheManager;
	private final ResourceLoader resourceLoader;

	@Autowired
	public CacheDataLoader(final CacheManager cacheManager, final ResourceLoader resourceLoader) {
		this.cacheManager = cacheManager;
		this.resourceLoader = resourceLoader;
	}

	public void loadSampleData() {

		this.loadProducts();
		this.loadIngredients();
	}

	private void loadIngredients() {

		JsonGenericDataLoader<Ingredient> ingredientDataLoader = new JsonGenericDataLoader<>(Ingredient.class,
				this.getInputStream("data/ingredients.json"));

		List<Ingredient> ingredients = ingredientDataLoader.loadData();

		this.cacheManager.getCache(CACHE_INSTANCE_NAME).put("ingredients", ingredients);

	}

	private void loadProducts() {

		JsonGenericDataLoader<Product> productDataLoader = new JsonGenericDataLoader<>(Product.class,
				this.getInputStream("data/products.json"));

		List<Product> products = productDataLoader.loadData();

		this.cacheManager.getCache(CACHE_INSTANCE_NAME).put("products", products);

	}

	private InputStream getInputStream(final String filePath) {
		try {
			return this.resourceLoader.getResource("classpath:" + filePath).getInputStream();
		} catch (IOException e) {
			LOGGER.error("", e);
		}

		return null;
	}

}
