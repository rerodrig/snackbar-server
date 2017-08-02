package br.com.snackbar.server.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;

import br.com.snackbar.server.model.Ingredient;

@Repository
public class IngredientRepository {

	@Autowired
	private CacheManager cacheManager;

	@SuppressWarnings("unchecked")
	public List<Ingredient> list() {
		return this.cacheManager.getCache("snackbar").get("ingredients", List.class);
	}

	public Ingredient find(final Integer id) {

		List<Ingredient> ingredients = this.list();

		Optional<Ingredient> ingredient = ingredients.stream().filter(l -> l.getId() == id).findFirst();

		return ingredient.isPresent() ? ingredient.get() : null;

	}

}
