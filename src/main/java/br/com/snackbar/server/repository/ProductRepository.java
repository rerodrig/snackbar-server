package br.com.snackbar.server.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;

import br.com.snackbar.server.model.Product;

@Repository
public class ProductRepository {

	@Autowired
	private CacheManager cacheManager;

	@SuppressWarnings("unchecked")
	public List<Product> list() {
		return this.cacheManager.getCache("snackbar").get("products", List.class);
	}
}
