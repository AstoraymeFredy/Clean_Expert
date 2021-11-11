package pe.edu.upc.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.Schedule;
import pe.edu.upc.spring.model.TypeUser;
import pe.edu.upc.spring.model.UserModel;
import pe.edu.upc.spring.service.iCleaningStaffService;
import pe.edu.upc.spring.service.iScheduleService;
import pe.edu.upc.spring.service.iUserService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping("/staff")
public class CleaningStaffController {
	
	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iCleaningStaffService csService;
	
	@Autowired
	private iScheduleService sService;
	
	@Autowired
	private iUserService uService;
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("staff", new CleaningStaff());
		return "/register/registerStaff";
	}
	
	@RequestMapping("/registerStaff")
	public String registerStaff (@ModelAttribute CleaningStaff objCleaningStaff, BindingResult binRes, Model model)throws ParseException{
		if(binRes.hasErrors()) {
			return "register";
		} else {
			UserModel user = objCleaningStaff.getUser();
			user.setType_user(new TypeUser(2, "ROLE_Personal_de_Limpieza"));
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			boolean flag = uService.createUser(user);
			if (flag) {
				objCleaningStaff.setUser(user);
				flag = csService.createCleaningStaff(objCleaningStaff);
				if (flag) {
					Schedule schedule = new Schedule();
					schedule.setCleaning_staff(objCleaningStaff);
					flag = sService.createSchedule(schedule);
				}
			}
			if(flag) {
				return "redirect:/";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/staff/register"; 
			}
		}
	}
	
	@Secured("ROLE_Personal_de_Limpieza")
	@RequestMapping("/view")
	public String goPageView(Model model) {
		model.addAttribute("staff", sesion.getCleaningStaff());
		return "/perfilStaff/view";
	}
	
	@Secured("ROLE_Personal_de_Limpieza")
	@RequestMapping("/edit")
	public String goPageEdit(Model model){
		model.addAttribute("staff", sesion.getCleaningStaff());
		return "/perfilStaff/update";
	}
	
	@Secured("ROLE_Personal_de_Limpieza")
	@RequestMapping("/editStaff")
	public String editClient(@ModelAttribute (value="staff") CleaningStaff objCleaningStaff, BindingResult binRes, Model model, HttpSession httpSession)throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/staff/edit";
		} else {
			boolean flag = csService.createCleaningStaff(objCleaningStaff);
			if(flag) {
				httpSession.setAttribute("nameUser", objCleaningStaff.getName() + " " + objCleaningStaff.getLastname());
				sesion.setCleaningStaff(objCleaningStaff);
				return "redirect:/staff/view";
			} else {
				return "redirect:/staff/edit";
			}
		}
	}
}
