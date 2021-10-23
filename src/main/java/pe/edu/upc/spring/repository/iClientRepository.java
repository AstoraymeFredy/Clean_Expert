package pe.edu.upc.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Client;

@Repository
public interface iClientRepository extends JpaRepository<Client, Integer> {
	
	@Query("from Client c where c.name like %:nameClient%")
	List<Client> searchByName(@Param("nameClient") String nameClient);
	
	@Query("from Client c where c.user.id_user=:idUser")
	Optional<Client> findByUserId(int idUser);
	
}
