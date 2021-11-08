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

	@Query("from Schedule s where lunes = True")
	List<Schedule> findHorarioByMonday();

	@Query("from Schedule s where martes = True")
	List<Schedule> findHorarioByTuesday();
	
	@Query("from Schedule s where miercoles = True")
	List<Schedule> findHorarioByWednesday();
	
	@Query("from Schedule s where jueves = True")
	List<Schedule> findHorarioByThursday();
	
	@Query("from Schedule s where viernes = True")
	List<Schedule> findHorarioByFriday();
	
	@Query("from Schedule s where sabado = True")
	List<Schedule> findHorarioBySaturday();
	
	@Query("from Schedule s where domingo = True")
	List<Schedule> findHorarioBySunday();
	
	@Query("from Schedule s where s.cleaning_staff.id_cleaning_staff=:idStaff")
	Optional<Schedule> findByIdStaff(@Param("idStaff") int idStaff);
}
