package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Schedule;

@Repository
public interface iScheduleRepository extends JpaRepository<Schedule, Integer> {

	@Query("from Schedule s where monday = True")
	List<Schedule> findHorarioByMonday();

	@Query("from Schedule s where tuesday = True")
	List<Schedule> findHorarioByTuesday();
	
	@Query("from Schedule s where wednesday = True")
	List<Schedule> findHorarioByWednesday();
	
	@Query("from Schedule s where thursday = True")
	List<Schedule> findHorarioByThursday();
	
	@Query("from Schedule s where friday = True")
	List<Schedule> findHorarioByFriday();
	
	@Query("from Schedule s where saturday = True")
	List<Schedule> findHorarioBySaturday();
	
	@Query("from Schedule s where sunday = True")
	List<Schedule> findHorarioBySunday();
	
	@Query("from Schedule s where s.cleaning_staff.id_cleaning_staff=:idStaff")
	Schedule findByIdStaff(@Param("idStaff") int idStaff);
}
