package ni.inventory.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ni.inventory.service.entity.Warehouse;
import ni.inventory.service.repository.OrganizationRepository;
import ni.inventory.service.repository.WarehouseRepository;

@RestController
@RequestMapping("/warehouse")
public class WareHouseController {
	
	@Autowired private final WarehouseRepository warehouseRepository;
	@Autowired private final OrganizationRepository organizationRepository;
	public WareHouseController(WarehouseRepository warehouseRepository, OrganizationRepository organizationRepository) {
		super();
		this.warehouseRepository = warehouseRepository;
		this.organizationRepository = organizationRepository;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Warehouse>> getAll() {
		var lst = warehouseRepository.findAll();
		if (lst == null || lst.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(lst);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Warehouse> getWarehouseByID(@PathVariable Long id) {
		var entity = warehouseRepository.findById(id).orElse(null);
		if (entity == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(entity);
	}
	
	@GetMapping("/organization/{organization_id}")
	public ResponseEntity<List<Warehouse>> getWarehouseByOrganizationID(@PathVariable Long organization_id) {
		var org = organizationRepository.findById(organization_id).orElse(null);
		if (org == null)
			return ResponseEntity.notFound().build();
		
		var wh = warehouseRepository.findByOrganization(org);

		return ResponseEntity.ok(wh);
	}

	@PostMapping("/add")
	public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse org) {
		return ResponseEntity.ok(warehouseRepository.save(org));
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Warehouse> editWarehouse(@RequestBody Warehouse newEntity, @PathVariable Long id){
		var entity =  warehouseRepository
				.findById(id).orElse(null);
				
				if (entity == null)
					return ResponseEntity.notFound().build();
			
				entity.setName(newEntity.getName());
				entity.setDescription(newEntity.getDescription());
				entity.setCode(newEntity.getCode());
				
				newEntity = warehouseRepository.save(entity);
				return ResponseEntity.ok(newEntity);
	}
	
}
