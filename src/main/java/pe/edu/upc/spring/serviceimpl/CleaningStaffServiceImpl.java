package pe.edu.upc.spring.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.repository.iCleaningStaffRepository;
import pe.edu.upc.spring.service.iCleaningStaffService;

@Service
public class CleaningStaffServiceImpl implements iCleaningStaffService {
	
	@Autowired
	private iCleaningStaffRepository dCleaningStaff;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public boolean createCleaningStaff(CleaningStaff cleaningStaff) {
		cleaningStaff.getUser().setPassword(passwordEncoder.encode(cleaningStaff.getUser().getPassword()));
		CleaningStaff objCleaningStaff = dCleaningStaff.save(cleaningStaff);
		if(objCleaningStaff==null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	@Transactional
	public boolean updateCleaningStaff(CleaningStaff cleaningStaff) {
		CleaningStaff objCleaningStaff = dCleaningStaff.save(cleaningStaff);
		if(objCleaningStaff==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public void deleteCleaningStaff(int idCleaningStaff) {
		dCleaningStaff.deleteById(idCleaningStaff);
	}

	@Override
	public Optional<CleaningStaff> findById(int idCleaningStaff) {
		return dCleaningStaff.findById(idCleaningStaff);
	}

	@Override
	public Optional<CleaningStaff> findByUserId(int idUser) {
		return dCleaningStaff.findByUserId(idUser);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CleaningStaff> listCleaningStaff() {
		return dCleaningStaff.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CleaningStaff> searchCleaningStaff(String nameCleaningStaff) {
		return dCleaningStaff.searchByName(nameCleaningStaff);
	}

	@Override
	public List<String[]> generalReport(int month) {
		if (month > 0) {
			return dCleaningStaff.generalReportByMonth(month);
		} else {
			return dCleaningStaff.generalReport();
		}
	}
	
	@Override
	public List<String[]> cleaningStaffReport() {	
		return dCleaningStaff.findTop2cleaningStaffReport();
	}
	
	@Override
	public List<String[]> cleaningStaffReportByDate(Date start_date, Date end_date) {
		return dCleaningStaff.cleaningStaffReportByRangeDate(start_date, end_date);
	}
	
}
