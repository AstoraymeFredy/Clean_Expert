package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.model.User;
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
	
	@RequestMapping("/gologin")
	public String goPageLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping("/login")
	public String Login(@ModelAttribute User objUser, BindingResult binRes, Model model)throws ParseException{
		if (binRes.hasErrors()) {
			
			return "login";
		} else {
			System.out.println(objUser.getUsername());
			System.out.println(objUser.getPassword());
		}
		return "login";
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
