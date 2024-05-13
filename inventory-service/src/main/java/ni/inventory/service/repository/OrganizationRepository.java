package ni.inventory.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ni.inventory.service.entity.Organization;

public interface OrganizationRepository extends  JpaRepository<Organization, Long>{

}
