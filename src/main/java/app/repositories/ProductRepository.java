package app.repositories;

import javax.persistence.EntityManager;

import app.models.Product;

@org.springframework.stereotype.Repository
public class ProductRepository extends Repository<Product> {

	protected ProductRepository(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
}
