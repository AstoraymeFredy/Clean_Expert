package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Schedule;
import pe.edu.upc.spring.repository.iScheduleRepository;
import pe.edu.upc.spring.service.iScheduleService;

@Service
public class ScheduleServiceImpl implements iScheduleService {

	@Autowired
	private iScheduleRepository dSchedule;
	
	@Override
	@Transactional
	public boolean createSchedule(Schedule schedule) {
		Schedule objSchedule = dSchedule.save(schedule);
		if(objSchedule==null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	@Transactional
	public boolean updateSchedule(Schedule schedule) {
		return true;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Schedule> findHorarioByDate(String filter){
		switch (filter) {
		case "lunes":
			return dSchedule.findHorarioByMonday();
		case "martes":
			return dSchedule.findHorarioByTuesday();
		case "miércoles":
			return dSchedule.findHorarioByWednesday();
		case "jueves":
			return dSchedule.findHorarioByThursday();
		case "viernes":
			return dSchedule.findHorarioByFriday();
		case "sábado":
			return dSchedule.findHorarioBySaturday();
		default:
			return dSchedule.findHorarioBySunday();
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Schedule findByIdStaff(int idStaff)
	{
		return dSchedule.findByIdStaff(idStaff);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Schedule> listSchedule()
	{
		return dSchedule.findAll();
	}
	
}
