package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Schedule;
import pe.edu.upc.spring.service.iScheduleService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private iScheduleService sService;

	@Autowired
	private Sesion sesion;

	@RequestMapping("/register")
	public String goPageRegister(Model model, RedirectAttributes objRedir) throws ParseException {
		Schedule objSch = sService.findByIdStaff(sesion.getCleaningStaff().getId_cleaning_staff());
		if (objSch == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/schedule/register";
		} else {
			if (objSch != null) {
				model.addAttribute("schedule", objSch);
			}
			return "schedule/update";
		}
	}

	@RequestMapping("/registerSchedule")
	public String registrar(@ModelAttribute Schedule objSchedule, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors())
			return "schedule";
		else {
			System.out.println(objSchedule.getId_schedule());
			System.out.println(objSchedule.isMonday());
			System.out.println(objSchedule.isSunday());
			boolean flag = sService.createSchedule(objSchedule);
			if (flag)
				return "redirect:/schedule/register";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/schedule/update";
			}
		}
	}

}
