package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Schedule;

@Repository
public interface iScheduleRepository extends JpaRepository<Schedule, Integer> {
	
	//List<Schedule> findByDate();
	
}
