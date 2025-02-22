package ni.inventory.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode
@ToString
@Table(name = "product")
public class Product {

	private @Id @GeneratedValue Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "brand_name", nullable = false)
	private String brandName;


	@ManyToOne
    @JoinColumn(name = "Product_category_id")
    private ProductCategory productCategory;
	
	public Product() {

	}

	public Product(String name, String code, String description, String brandName, ProductCategory productCategory) {
		super();
		this.id = null;
		this.name = name;
		this.code = code;
		this.description = description;
		this.brandName = brandName;
		this.productCategory = productCategory;
	}

}
