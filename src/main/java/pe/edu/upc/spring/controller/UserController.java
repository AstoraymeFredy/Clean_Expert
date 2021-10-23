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
import pe.edu.upc.spring.model.User;
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
			Optional<User> findedUser = uService.findByUsernameAndPassword(objUser.getUsername(), objUser.getPassword());
			if(findedUser.isPresent()) {
				System.out.println("1");
				User currentUser = findedUser.get();
				System.out.println("/");
				sesion.setUser(currentUser);
				System.out.println("//");
				if(currentUser.getType_user().getId_type_user() == 1) {
					System.out.println("2");
					Optional<Client> findedClient =cService.findByUserId(currentUser.getId_user());
					if(findedClient.isPresent()) {
						System.out.println("3");
						Client client = findedClient.get();
						sesion.setClient(client);
						return "/reservation/list";
					} else {
						System.out.println("4");
						return "login";
					}
				} else {
					System.out.println("5");
					
					return "login";
				}
			} else {
				System.out.println("6");
				return "login";
			}
		}
	}
	
	@RequestMapping("/logout")
	public String Logout() {
		sesion.setUser(new User());
		sesion.setClient(new Client());
		sesion.setCleaningStaff(new CleaningStaff());
		return "login";
	}
	
	
}
