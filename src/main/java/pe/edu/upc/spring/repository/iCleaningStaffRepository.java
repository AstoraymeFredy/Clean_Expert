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
	
	@Query(value = "SELECT pl.id_cleaning_staff, pl.nombre, pl.apellidos,count(r.id_reservation)"
			+ " from personal_limpieza pl join reserva r on r.id_personal_limpieza=pl.id_cleaning_staff"
			+ " group by pl.id_cleaning_staff"
			+ " ORDER BY count(r.id_reservation)  DESC "
			+ " limit 5", nativeQuery = true)
	public List<String[]> generalReport();
}
