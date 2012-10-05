package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.models.Product;
import app.repositories.ProductRepository;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Result result;
	@Autowired
	private Validator validator;
	
	@Get @Path("/products")
	public List<Product> list() {
		return getProductRepository().findAll();
	}

	// -- Dummy
	public void form() {
	}
	
	@Post("/products/{product.id}")
	public void add(final Product product) {
		
		getValidator().checking(new Validations(){ {
			that(!product.getName().isEmpty(), "product.name" , "name.empty");
			that(product.getPrice() != null && product.getPrice() > 0 , "product.price" , "invalid.price");
		} } );
		
		getValidator().onErrorUsePageOf(ProductController.class).form();
		
		getProductRepository().create(product);
		
		getResult().redirectTo(ProductController.class).list();
	}

	@Get("/products/{product.id}")
	public Product view(Product product) {
		return getProductRepository().find(product.getId());
	}
	
	@Put("/products/{product.id}")
	public void update(Product product) {
		getProductRepository().update(product);
	}
	
	@Delete("/products/{product.id}")
	public void remove(Product product) {
		getProductRepository().destroy(product);
	}
	
	// -- getters and setters
	
	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public Result getResult() {
		return result;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	
	
}
