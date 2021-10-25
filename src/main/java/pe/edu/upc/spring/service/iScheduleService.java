package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Schedule;

public interface iScheduleService {
	public boolean createSchedule(Schedule schedule);
	public Optional<Schedule> listId(int id_schedule);
	List<Schedule> list();
}
