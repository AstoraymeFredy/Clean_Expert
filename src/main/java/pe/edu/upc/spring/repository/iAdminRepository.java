package pe.edu.upc.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Admin;

@Repository
public interface iAdminRepository extends JpaRepository<Admin, Integer> {
	@Query("from Admin c where c.name like %:nameAdmin%")
	List<Admin> searchByName(@Param("nameAdmin") String nameAdmin);
	
	@Query("from Admin c where c.user.id_user=:idUser")
	Optional<Admin> findByUserId(int idUser);
}
