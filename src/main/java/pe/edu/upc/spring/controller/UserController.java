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
	
	@RequestMapping("/login")
	public String goPageLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String Login(@ModelAttribute User objUser, BindingResult binRes, Model model)throws ParseException{
		if (binRes.hasErrors()) {
			return "redirect:/user/login";
		} else {
			Optional<User> findedUser = uService.findByUsernameAndPassword(objUser.getUsername(), objUser.getPassword());
			if(findedUser.isPresent()) {
				User currentUser = findedUser.get();
				sesion.setUser(currentUser);
				if(currentUser.getType_user().getId_type_user() == 1) {
					Optional<Client> findedClient =cService.findByUserId(currentUser.getId_user());
					if(findedClient.isPresent()) {
						Client client = findedClient.get();
						sesion.setClient(client);
						model.addAttribute("client", client);
						return "redirect:/reservation/client/list";
					} else {
						return "redirect:/user/login";
					}
				} else {
					Optional<CleaningStaff> findedCleaningStaff =csService.findByUserId(currentUser.getId_user());
					if(findedCleaningStaff.isPresent()) {
						CleaningStaff cleaningStaff = findedCleaningStaff.get();
						sesion.setCleaningStaff(cleaningStaff);
						return "redirect:/service/list";
					} else {
						return "redirect:/user/login";
					}
				}
			} else {
				return "redirect:/user/login";
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
