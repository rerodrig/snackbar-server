package br.com.snackbar.server.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.snackbar.server.assembler.ProductItemAssembler;
import br.com.snackbar.server.dto.ProductItemDTO;
import br.com.snackbar.server.model.Product;
import br.com.snackbar.server.model.ProductItem;
import br.com.snackbar.server.repository.ProductRepository;
import br.com.snackbar.server.service.price.ProductPriceCalculator;

@Service
public class ProductService {

	@Autowired
	private ProductItemAssembler productItemAssembler;

	@Autowired
	private ProductPriceCalculator calculator;

	@Autowired
	private ProductRepository productRepository;

	public BigDecimal calculatePrice(final List<ProductItemDTO> items) {

		List<ProductItem> productItems = this.productItemAssembler.toModelList(items);

		return this.calculator.calculate(productItems);

	}

	public List<Product> list() {
		return this.productRepository.list();
	}

}
