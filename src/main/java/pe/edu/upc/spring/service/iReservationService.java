package pe.edu.upc.spring.service;

import java.util.Date;
import java.util.List;

import pe.edu.upc.spring.model.Reservation;

public interface iReservationService {
	public Reservation createReservation(Reservation reservation);
	public Reservation findById(int idReservation);
	public List<Reservation> listByDate(Date date);
	public List<Reservation> listByCleaningStaff(int idCleaningStaff);
	public List<Reservation> listByClient(int idClient);
}
