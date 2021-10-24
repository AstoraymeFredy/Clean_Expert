package pe.edu.upc.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Reservation;

public interface iReservationService {
	public boolean createReservation(Reservation reservation);
	public Optional<Reservation> findById(int idReservation);
	public List<Reservation> listByDate(Date date);
	public List<Reservation> listByCleaningStaff(int idCleaningStaff);
	public List<Reservation> listByClient(int idClient);
}
