package ni.inventory.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ni.inventory.service.entity.ProductCategory;

public interface ProductCategoryRepository extends  JpaRepository<ProductCategory, Long>{

}
