package ni.inventory.service.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode
@ToString
@Table(name = "organization")
public class Organization {

	private @Id @GeneratedValue Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "description", nullable = false)
	private String description;
	
	private Boolean isActive;
	
	@OneToMany
    @JoinColumn(name = "organization_id") 
	private Set<Warehouse> whareHouses;
	
	public Organization() {
		
	}

	public Organization(String name, String code, String description, Boolean isActive) {
		super();
		this.id = null;
		this.name = name;
		this.code = code;
		this.description = description;
		this.isActive = isActive;
	}
	
	
	
}
