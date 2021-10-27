package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.model.DetailReservation;

public interface iDetailReservationService {
	public boolean createDetailReservation(DetailReservation detailReservation);
	public List<DetailReservation> listByReservation(int idResrvation);
}
