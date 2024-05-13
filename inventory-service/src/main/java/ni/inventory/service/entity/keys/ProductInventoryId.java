package ni.inventory.service.entity.keys;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ProductInventoryId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long productId;
	private Long warehouseId;
	
	public ProductInventoryId(Long productId, Long warehouseId) {
		super();
		this.productId = productId;
		this.warehouseId = warehouseId;
	}

	public ProductInventoryId() {
		super();
		// TODO Auto-generated constructor stub
	}

}
