package pe.edu.upc.spring.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Reservation;
import pe.edu.upc.spring.repository.iReservationRepository;
import pe.edu.upc.spring.service.iReservationService;

@Service
public class ReservationServiceImpl implements iReservationService {
	
	@Autowired
	private iReservationRepository dReservation;
	
	@Override
	@Transactional
	public Reservation createReservation(Reservation reservation) {
		Reservation objReservation = dReservation.save(reservation);
		if(objReservation==null) {
			return new Reservation();
		} else {
			return objReservation;
		}
	}
		
	@Override
	public Optional<Reservation> findById(int idReservation) {
		return dReservation.findById(idReservation);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> listByDate(Date date) {
		return dReservation.findByDate(date);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> listByCleaningStaff(int idCleaningStaff) {
		return dReservation.findByCleaningStaffId(idCleaningStaff);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> listByClient(int idClient) {
		return dReservation.findByClientId(idClient);
	}
	
}
