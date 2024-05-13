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

import ni.inventory.service.entity.Organization;
import ni.inventory.service.repository.OrganizationRepository;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

	@Autowired
	private final OrganizationRepository organizationRepository;

	public OrganizationController(OrganizationRepository organizationRepository) {
		super();
		this.organizationRepository = organizationRepository;
	}

	@GetMapping("")
	public ResponseEntity<List<Organization>> getAll() {
		List<Organization> lst = organizationRepository.findAll();
		if (lst == null || lst.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(lst);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Organization> getOrganizationByID(@PathVariable Long id) {
		var org = organizationRepository.findById(id).orElse(null);
		if (org == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(org);
	}

	@PostMapping("/add")
	public ResponseEntity<Organization> addOrganization(@RequestBody Organization org) {
		return ResponseEntity.ok(organizationRepository.save(org));
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Organization> editOrganization(@RequestBody Organization newOrg, @PathVariable Long id){
		Organization org =  organizationRepository
				.findById(id).orElse(null);
				
				if (org == null)
					return ResponseEntity.notFound().build();
			
				org.setName(newOrg.getName());
				org.setDescription(newOrg.getDescription());
				org.setCode(newOrg.getCode());
				
				newOrg = organizationRepository.save(org);
				return ResponseEntity.ok(newOrg);
	}
}