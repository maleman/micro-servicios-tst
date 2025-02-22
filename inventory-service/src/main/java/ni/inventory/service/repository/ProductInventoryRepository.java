package ni.inventory.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ni.inventory.service.entity.ProductInventory;
import ni.inventory.service.entity.keys.ProductInventoryId;

public interface ProductInventoryRepository extends  JpaRepository<ProductInventory, ProductInventoryId>{

}
