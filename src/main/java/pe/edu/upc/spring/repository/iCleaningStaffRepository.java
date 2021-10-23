package pe.edu.upc.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.CleaningStaff;

@Repository
public interface iCleaningStaffRepository extends JpaRepository<CleaningStaff, Integer> {
	
	@Query("from CleaningStaff c where c.name like %:nameCleaningStaff%")
	List<CleaningStaff> searchByName(@Param("nameCleaningStaff") String nameCleaningStaff);
	
	@Query("from CleaningStaff c where c.user.id_user=:idUser")
	Optional<CleaningStaff> findByUserId(int idUser);
}
