package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.models.Product;
import app.repositories.ProductRepository;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Result result;
	
	public List<Product> list() {
		return productRepository.findAll();
	}

	// -- Dummy
	public void form() {
	}
	
	public void add(Product product) {
		productRepository.create(product);
	}
}
