package ni.inventory.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ni.inventory.service.entity.Organization;
import ni.inventory.service.entity.Warehouse;

public interface WarehouseRepository  extends JpaRepository<Warehouse, Long>{
	
	List<Warehouse> findByOrganization(Organization organization);

}
