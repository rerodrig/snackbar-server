package br.com.snackbar.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository repository;

	public List<Ingredient> list() {
		return this.repository.list();
	}

}
