package pe.edu.upc.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Schedule;

@Repository
public interface iScheduleRepository extends JpaRepository<Schedule, Integer> {
	@Query("from Schedule s where :filter = True")
	List<Schedule> findHorarioByDate(@Param("filter") String filter);
	
	@Query("from Schedule s where s.cleaning_staff.id_cleaning_staff=:idStaff")
	Optional<Schedule> findByIdStaff(@Param("idStaff") int idStaff);
}
