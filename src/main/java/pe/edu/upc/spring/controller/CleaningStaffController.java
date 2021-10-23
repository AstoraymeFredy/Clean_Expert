package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.Schedule;
import pe.edu.upc.spring.model.TypeUser;
import pe.edu.upc.spring.model.User;
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
			User user = objCleaningStaff.getUser();
			user.setType_user(new TypeUser(2, "Personal de limpieza"));
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
				return "redirect:/user/login";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/staff/register"; 
			}
		}
	}
	
	@RequestMapping("/edit")
	public String goPageEdit(Model model) {
		model.addAttribute("client", sesion.getCleaningStaff());
		return "";
	}
}
