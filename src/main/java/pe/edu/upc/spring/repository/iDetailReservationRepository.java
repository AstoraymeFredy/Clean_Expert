package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DetailReservation;

@Repository
public interface iDetailReservationRepository extends JpaRepository<DetailReservation, Integer> {
	
	@Query("from DetailReservation r where r.reservation.id_reservation = :idReservation")
	List<DetailReservation> findByReservationId(@Param("idReservation") int idReservation);
}

