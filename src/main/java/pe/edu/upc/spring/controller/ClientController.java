package pe.edu.upc.spring.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
		return "register/registerClient";
	}

	@RequestMapping("/registerClient")
	public String registerClient(@Valid @ModelAttribute Client objClient, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "register/registerClient";
		} else {
			UserModel user = objClient.getUser();
			user.setType_user(new TypeUser(1, "Cliente"));
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			UserModel userRepeat = uService.findByUsernameRepeated(user.getUsername());
			if (userRepeat != null) {
				model.addAttribute("error",
						"Error: El nombre de usuario o contraseña ya existe. Por favor ingrese otros valores.");
				return "register/registerClient";
			}

			boolean flag = uService.createUser(user);
			if (flag) {
				objClient.setUser(user);
				flag = cService.createClient(objClient);
			}
			if (flag) {
				return "redirect:/login";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/client/register";
			}
		}
	}

	@Secured("ROLE_Cliente")
	@RequestMapping("/view")
	public String goPageView(Model model) {
		model.addAttribute("client", sesion.getClient());
		return "perfilClient/view";
	}

	@Secured("ROLE_Cliente")
	@RequestMapping("/edit")
	public String goPageEdit(Model model) {
		model.addAttribute("clientEdit", sesion.getClient());
		return "perfilClient/update";
	}

	@Secured("ROLE_Cliente")
	@RequestMapping("/editClient")
	public String editClient(@Valid @ModelAttribute(value = "clientEdit") Client objClient, BindingResult binRes,
			Model model, HttpSession httpSession) throws ParseException {
		if (binRes.hasErrors()) {
			return "perfilClient/update";
		} else {
			boolean flag = cService.updateClient(objClient);
			if (flag) {
				httpSession.setAttribute("nameUser", objClient.getName() + " " + objClient.getLastname());
				sesion.setClient(objClient);
				return "redirect:/client/view";
			} else {
				return "redirect:/client/edit";
			}
		}
	}

}
