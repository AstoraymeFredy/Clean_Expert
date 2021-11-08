package pe.edu.upc.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.model.UserModel;
import pe.edu.upc.spring.service.iCleaningStaffService;
import pe.edu.upc.spring.service.iClientService;
import pe.edu.upc.spring.service.iUserService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iUserService uService;
	
	@Autowired
	private iClientService cService;
	
	@Autowired
	private iCleaningStaffService csService;
	
	
	
	@RequestMapping("/logout")
	public String Logout() {
		sesion.setUser(new UserModel());
		sesion.setClient(new Client());
		sesion.setCleaningStaff(new CleaningStaff());
		return "login";
	}
	
	
}
