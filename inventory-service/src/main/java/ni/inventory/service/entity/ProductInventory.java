package ni.inventory.service.entity;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ni.inventory.service.entity.keys.ProductInventoryId;

@Entity
@Data
@EqualsAndHashCode
@ToString
@Table(name = "product_Inventory")
public class ProductInventory {
	
	@EmbeddedId
	private ProductInventoryId id;
	
	private BigDecimal qtyReserved;
	private BigDecimal qtyOnHand;
	
	public ProductInventory(ProductInventoryId id, BigDecimal qtyReserved, BigDecimal qtyOnHand) {
		super();
		this.id = id;
		this.qtyReserved = qtyReserved;
		this.qtyOnHand = qtyOnHand;
	}

	public ProductInventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
