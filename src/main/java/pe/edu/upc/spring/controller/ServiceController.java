package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.utils.Sesion;
import pe.edu.upc.spring.model.Reservation;
import pe.edu.upc.spring.service.iReservationService;
import pe.edu.upc.spring.service.iDetailReservationService;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iReservationService rService;
	
	@Autowired
	private iDetailReservationService dService;
	
	@RequestMapping("/list")
	public String listReservationByClient(Map<String, Object> model) {
		model.put("listServices", rService.listByCleaningStaff(sesion.getCleaningStaff().getId_cleaning_staff()));
		return "/service/list";
	}	
	
	@RequestMapping("/view/{id}")
	public String goPageView(@PathVariable int id, Model model, RedirectAttributes objRedir,Map<String, Object> modelList)
		throws ParseException 
	{
		Optional<Reservation> objRes = rService.findById(id);
		if (objRes == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/service/list";
		}
		else {	
			if (objRes.isPresent())
				objRes.ifPresent(o -> model.addAttribute("service", o));
			
			modelList.put("listDetailsService", dService.listByReservation(id));

			return "service/view";
		}
	}	
	
	
}
