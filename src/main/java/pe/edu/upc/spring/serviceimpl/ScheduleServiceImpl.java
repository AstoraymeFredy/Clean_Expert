package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

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
	@Transactional(readOnly = true)
	public Optional<Schedule> listId(int id_schedule) {
		return dSchedule.findById(id_schedule);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Schedule> list() {
		return dSchedule.findAll();
	}
	
}
