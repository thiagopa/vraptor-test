package app.models;

import java.io.Serializable;

import javax.persistence.Column;

@javax.persistence.Entity
public class Product extends Entity implements Serializable {

	private static final long serialVersionUID = -6449163612588864855L;
	
	@Column(nullable =false, length = 30, unique = true)
	private String name;
	@Column(nullable = false, length = 100)
	private String description;
	@Column(nullable = false)
	private Double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
