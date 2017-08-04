package br.com.snackbar.server.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.snackbar.server.dto.ProductItemDTO;
import br.com.snackbar.server.model.Product;
import br.com.snackbar.server.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> listAll() {

		List<Product> products = this.productService.list();

		return ResponseEntity.ok(products);

	}

	@PostMapping("calculatePrice")
	public ResponseEntity<BigDecimal> calculatePrice(@RequestBody final List<ProductItemDTO> items) {

		BigDecimal price = this.productService.calculatePrice(items);

		return ResponseEntity.ok(price);

	}

}
