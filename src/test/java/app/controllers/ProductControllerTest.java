package app.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import app.models.Product;
import app.repositories.ProductRepository;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;

public class ProductControllerTest {

	private ProductController productController;
	private Product product; 
	private ProductRepository productRepository;
	
	@Before
	public void setUp() {
		productController = new ProductController();
		
		productRepository = mock(ProductRepository.class);
		
		productController.setProductRepository(productRepository);
		productController.setValidator(new MockValidator());
		productController.setResult(new MockResult());
		
		product = new Product();
		product.setName("Test");
		product.setPrice(10.5);
		product.setId(1l);
	}
	
	@Test
	public void testList() {
		List m = new ArrayList();
		m.add(product);
		
		when(productRepository.findAll()).thenReturn(m);
		
		assertEquals(m, productController.list());
	}

	@Test
	public void testAdd() {
		
		productController.add(product);
		
	}

	@Test(expected=br.com.caelum.vraptor.validator.ValidationException.class)
	public void testAddEmptyNameError() {
		
		product.setName("");
		
		productController.add(product);
		
	}

	@Test(expected=br.com.caelum.vraptor.validator.ValidationException.class)
	public void testAddNullPriceError() {
		
		product.setPrice(null);
		
		productController.add(product);
		
	}

	@Test(expected=br.com.caelum.vraptor.validator.ValidationException.class)
	public void testAddNegativePriceError() {
		
		product.setPrice(-1000.0);
		
		productController.add(product);
		
	}

		
	
	@Test
	public void testView() {
		
		when(productRepository.find(product.getId())).thenReturn(product);
		
		Product result = productController.view(product);
		
		assertEquals(product,result);
	}

	@Test
	public void testUpdate() {
		productController.update(product);
	}

	@Test
	public void testRemove() {
		productController.remove(product);
	}

}
