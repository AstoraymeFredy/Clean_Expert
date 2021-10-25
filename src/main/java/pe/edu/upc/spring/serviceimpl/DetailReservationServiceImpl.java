package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.DetailReservation;
import pe.edu.upc.spring.repository.iDetailReservationRepository;
import pe.edu.upc.spring.service.iDeatailReservationService;

@Service
public class DetailReservationServiceImpl implements iDeatailReservationService {
	
	@Autowired
	private iDetailReservationRepository dDetailReservation;
	
	@Override
	@Transactional
	public boolean createDetailReservation(DetailReservation detailReservation) {
		DetailReservation objDetailReservation = dDetailReservation.save(detailReservation);
		if(objDetailReservation==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetailReservation> listByReservation(int idResrvation) {
		return dDetailReservation.findByReservationId(idResrvation);
	}
	
}
