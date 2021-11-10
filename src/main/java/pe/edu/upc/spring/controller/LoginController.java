package pe.edu.upc.spring.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.model.CustomUser;
import pe.edu.upc.spring.service.iAdminService;
import pe.edu.upc.spring.service.iCleaningStaffService;
import pe.edu.upc.spring.service.iClientService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iClientService cService;
	
	@Autowired
	private iCleaningStaffService csService;
	
	@Autowired
	private iAdminService aService;
	
	@GetMapping(value = { "/login", "/" })
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash, HttpSession httpSession) {
		if (principal != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			CustomUser customUser = (CustomUser)authentication.getPrincipal();
			if(customUser.getTypeUserID() == 1) {
				Optional<Client> findedClient =cService.findByUserId(customUser.getUserID());
				Client client = findedClient.get();
				sesion.setClient(client);
				model.addAttribute("client", client);
				httpSession.setAttribute("nameUser", client.getName() + client.getLastname());
				return "redirect:/reservation/list";
			} else {
				if (customUser.getTypeUserID() == 2) {
					Optional<CleaningStaff> findedCleaningStaff =csService.findByUserId(customUser.getUserID());
					CleaningStaff cleaningStaff = findedCleaningStaff.get();
					httpSession.setAttribute("nameUser", cleaningStaff.getName() + cleaningStaff.getLastname());
					sesion.setCleaningStaff(cleaningStaff);
					return "redirect:/service/list";
				} else {
					Optional<Admin> findedAdmin =aService.findByUserId(customUser.getUserID());
					Admin admin = findedAdmin.get();
					httpSession.setAttribute("nameUser", admin.getName() + admin.getLastname());
					sesion.setAdmin(admin);
					return "redirect:/admin/staff/list";
				}
			}
			
		}

		if (error != null) {
			model.addAttribute("error",
					"Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}

		if (logout != null) {
			sesion.setCleaningStaff(new CleaningStaff());
			sesion.setClient(new Client());
			sesion.setAdmin(new Admin());
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}

		return "login";
	}
}
