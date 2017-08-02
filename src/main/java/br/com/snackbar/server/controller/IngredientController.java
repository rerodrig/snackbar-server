package br.com.snackbar.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.snackbar.server.model.Ingredient;
import br.com.snackbar.server.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	private IngredientService service;

	@GetMapping
	public ResponseEntity<List<Ingredient>> listAll() {

		List<Ingredient> ingredients = this.service.list();

		return ResponseEntity.ok(ingredients);
	}
}
