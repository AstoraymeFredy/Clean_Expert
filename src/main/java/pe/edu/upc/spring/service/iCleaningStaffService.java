package pe.edu.upc.spring.service;

import java.util.Date;
import java.util.List;

import pe.edu.upc.spring.model.CleaningStaff;

public interface iCleaningStaffService {
	public boolean createCleaningStaff(CleaningStaff cleaningStaff);

	public boolean updateCleaningStaff(CleaningStaff cleaningStaff);

	public void deleteCleaningStaff(int idCleaningStaff);

	public CleaningStaff findById(int idCleaningStaff);

	public CleaningStaff findByUserId(int idUser);

	public List<CleaningStaff> listCleaningStaff();

	public List<CleaningStaff> searchCleaningStaff(String nameCleaningStaff);

	public List<String[]> generalReport(int month);

	public List<String[]> cleaningStaffReport();

	public List<String[]> cleaningStaffReportByDate(Date start_date, Date end_date);

}
