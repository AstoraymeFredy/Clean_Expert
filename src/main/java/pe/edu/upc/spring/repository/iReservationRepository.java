package pe.edu.upc.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Reservation;

@Repository
public interface iReservationRepository extends JpaRepository<Reservation, Integer> {
	
	@Query("from Reservation r where r.cleaningStaff.id_cleaning_staff = :idCleaningStaff")
	List<Reservation> findByCleaningStaffId(@Param("idCleaningStaff") int idCleaningStaff);
	
	@Query("from Reservation r where r.property.client.id_client = :idClient")
	List<Reservation> findByClientId(@Param("idClient") int idClient);
	
    List<Reservation> findByDate(Date date);
    
    Reservation findById(int id);

}

