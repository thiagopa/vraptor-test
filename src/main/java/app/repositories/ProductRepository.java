package app.repositories;

import javax.persistence.EntityManager;

import app.models.Product;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ProductRepository extends Repository<Product> {

	public ProductRepository(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
}
