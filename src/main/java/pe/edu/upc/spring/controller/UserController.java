package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.service.iUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private iUserService uService;
	
	@RequestMapping("/1")
	public String goPageRegisterClient() {
		return "";
	}
	
	@RequestMapping("/2")
	public String goPageRegisterStaff() {
		return "";
	}
	
	@RequestMapping("/3")
	public String goPageLogin() {
		return "";
	}
	
	@RequestMapping("/4")
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
