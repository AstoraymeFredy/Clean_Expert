package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Property;

@Repository
public interface iPropertyRepository extends JpaRepository<Property, Integer>{
	
	@Query("from Property p where p.client.id_client=:idClient")
	List<Property> findByClientId(int idClient);
}
