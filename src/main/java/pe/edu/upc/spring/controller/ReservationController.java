package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private Sesion sesion;
	
	@RequestMapping("/test")
	public String Test() {
		System.out.println("nombre usuario");
		System.out.println(sesion.getUser().getUsername());
		System.out.println("nombre cliente");
		System.out.println(sesion.getClient().getName());
		return "/reservation/list";
	}
	
}
