package ni.inventory.service.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode
@ToString
@Table(name = "product_category")
public class ProductCategory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "description", nullable = false)
	private String description;
	
	//@OneToMany
    //@JoinColumn(name = "Product_category_id") 
    //private List<Product> Products;
	
	public ProductCategory() {}

	public ProductCategory(String name, String code, String description) {
		super();
		this.id = null;
		this.name = name;
		this.code = code;
		this.description = description;
	}
	
	
}
