package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.service.iUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private iUserService uService;
	
	@RequestMapping("/1")
	public String goPageRegisterClient(Model model) {
		model.addAttribute("client", new Client());
		return "";
	}
	
	@RequestMapping("/2")
	public String goPageRegisterStaff(Model model) {
		model.addAttribute("staff", new CleaningStaff());
		return "";
	}
	
	@RequestMapping("/login")
	public String goPageLogin() {
		return "index";
	}
	
	@RequestMapping("/")
	public String Login() {
		return "";
	}
	
	@RequestMapping("/5")
	public String Logout() {
		return "";
	}
	
	@RequestMapping("/6")
	public String RegisterUser() {
		return "";
	}
	
}
