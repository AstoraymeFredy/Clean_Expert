package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.model.TypeUser;
import pe.edu.upc.spring.model.UserModel;
import pe.edu.upc.spring.service.iClientService;
import pe.edu.upc.spring.service.iUserService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iClientService cService;
	
	@Autowired
	private iUserService uService;
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("client", new Client());
		return "/register/registerClient";
	}
	
	@RequestMapping("/registerClient")
	public String registerClient(@ModelAttribute Client objClient, BindingResult binRes, Model model)throws ParseException{
		if (binRes.hasErrors()) {
			return "redirect:/client/register";
		} else {
			UserModel user = objClient.getUser();
			user.setType_user(new TypeUser(1, "Cliente"));
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			boolean flag = uService.createUser(user);
			if(flag) {
				objClient.setUser(user);
				flag = cService.createClient(objClient);
			} 
			if (flag) {
				return "redirect:/user/login";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/client/register"; 
			}
			
		}
		
	}
	
	@RequestMapping("/view")
	public String goPageView(Model model) {
		model.addAttribute("client", sesion.getClient());
		return "/perfilClient/view";
	}
	
	@RequestMapping("/edit")
	public String goPageEdit(Model model){
		model.addAttribute("clientEdit", sesion.getClient());
		return "/perfilClient/update";
	}
	
	@RequestMapping("/editClient")
	public String editClient(@ModelAttribute(value="clientEdit") Client objClient, BindingResult binRes, Model model)throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/client/edit";
		} else {
			boolean flag = cService.createClient(objClient);
			if(flag) {
				sesion.setClient(objClient);
				return "redirect:/client/view";
			} else {
				return "redirect:/client/edit";
			}
		}
	}
	
}
