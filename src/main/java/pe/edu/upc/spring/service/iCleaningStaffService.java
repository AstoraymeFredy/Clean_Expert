package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.CleaningStaff;

public interface iCleaningStaffService {
	public boolean createCleaningStaff(CleaningStaff cleaningStaff);
	public boolean updateCleaningStaff(CleaningStaff cleaningStaff);
	public void deleteCleaningStaff(int idCleaningStaff);
	public Optional<CleaningStaff> findById(int idCleaningStaff);
	public Optional<CleaningStaff> findByUserId(int idUser);
	public List<CleaningStaff> listCleaningStaff();
	public List<CleaningStaff> searchCleaningStaff(String nameCleaningStaff);
	public List<String[]> generalReport();
}
