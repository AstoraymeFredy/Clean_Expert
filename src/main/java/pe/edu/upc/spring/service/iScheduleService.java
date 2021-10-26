package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Schedule;

public interface iScheduleService {
	public boolean createSchedule(Schedule schedule);
	public boolean updateSchedule(Schedule schedule);
	public List<Schedule> findHorarioByDate(String filter);
	public Optional<Schedule> findByIdStaff(int idStaff);
	public List<Schedule> listSchedule();
}
