package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.repository.iCleaningStaffRepository;
import pe.edu.upc.spring.service.iCleaningStaffService;

@Service
public class CleaningStaffServiceImpl implements iCleaningStaffService {
	
	@Autowired
	private iCleaningStaffRepository dCleaningStaff;

	@Override
	@Transactional
	public boolean createCleaningStaff(CleaningStaff cleaningStaff) {
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
	
}
