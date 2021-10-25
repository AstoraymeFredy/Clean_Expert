package pe.edu.upc.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.utils.Sesion;
import pe.edu.upc.spring.model.Reservation;
import pe.edu.upc.spring.service.iReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iReservationService dReservation;
	
	@RequestMapping("/client/list")
	public String listReservationByClient(Map<String, Object> model) {
		model.put("listReservations", dReservation.listByClient(sesion.getClient().getId_client()));
		return "/reservation/list";
	}		
	
}
