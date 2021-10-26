package pe.edu.upc.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.model.TypeUser;
import pe.edu.upc.spring.model.User;
import pe.edu.upc.spring.service.iAdminService;
import pe.edu.upc.spring.service.iUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private iUserService uService;
	
	@Autowired
	private iAdminService aService;
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("admin", new Admin());
		return "/admin/register";
	}
	
	@RequestMapping("/list")
	public String goPageList(Map<String, Object> model) {
		model.put("listAdmin", aService.listAdmin());
		return "/admin/list";
	}
	
	@RequestMapping("/registerAdmin")
	public String registerClient(@ModelAttribute Admin objAdmin, BindingResult binRes, Model model)throws ParseException{
		if (binRes.hasErrors()) {
			return "registerAdmin";
		} else {
			User user = objAdmin.getUser();
			user.setType_user(new TypeUser(3, "Administrador"));
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			boolean flag = uService.createUser(user);
			if(flag) {
				objAdmin.setUser(user);
				flag = aService.createAdmin(objAdmin);
			} 
			if (flag) {
				return "redirect:/admin/list";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/admin/register"; 
			}
			
		}
		
	}
	
}
