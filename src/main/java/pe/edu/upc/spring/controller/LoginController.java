package pe.edu.upc.spring.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.model.CustomUser;
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
	
	@GetMapping(value = { "/login", "/" })
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {
		if (principal != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			CustomUser customUser = (CustomUser)authentication.getPrincipal();
			System.out.println("==========");
			System.out.println(customUser.getTypeUserID());
			if(customUser.getTypeUserID() == 1) {
				Optional<Client> findedClient =cService.findByUserId(customUser.getUserID());
				Client client = findedClient.get();
				sesion.setClient(client);
				model.addAttribute("client", client);
				return "redirect:/reservation/list";
			} else {
				if (customUser.getTypeUserID() == 2) {
					System.out.println(customUser.getTypeUserID());
					System.out.println("++++++++++++");
					Optional<CleaningStaff> findedCleaningStaff =csService.findByUserId(customUser.getUserID());
					System.out.println(findedCleaningStaff.get());
					CleaningStaff cleaningStaff = findedCleaningStaff.get();
					System.out.println(cleaningStaff.getName());
					sesion.setCleaningStaff(cleaningStaff);
					return "redirect:/service/list";
				} else {
					return "redirect:/admin/staff/list";
				}
			}
			
		}

		if (error != null) {
			model.addAttribute("error",
					"Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}

		if (logout != null) {
			System.out.println("saleee");
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}

		return "login";
	}
}
