package pe.edu.upc.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Reservation;
import pe.edu.upc.spring.model.Valoration;
import pe.edu.upc.spring.service.iReservationService;
import pe.edu.upc.spring.service.iValorationService;

@Controller
@RequestMapping("/valoration")
public class ValorationController {

	@Autowired
	private iValorationService vService;

	@Autowired
	private iReservationService rService;

	@RequestMapping("/register/{id}")
	public String goPageRegister(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Reservation objRes = rService.findById(id);
		if (objRes == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/valoration/listar";
		} else {
			Valoration objValoration = new Valoration();
			if (objRes != null) {
				objValoration.setClient(objRes.getProperty().getClient());
				objValoration.setCleaning_staff(objRes.getCleaningStaff());
			}
			model.addAttribute("valoration", objValoration);
			return "valoration/create";
		}
	}

	@RequestMapping("/registerValoration")
	public String register(@Valid @ModelAttribute ("valoration") Valoration objValoration, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors())
			return "valoration/create";
		else {
			boolean flag = vService.createValoration(objValoration);
			if (flag)
				return "redirect:/reservation/list";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/valoration/register";
			}
		}
	}
}
