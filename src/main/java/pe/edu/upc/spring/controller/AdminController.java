package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.TypeUser;
import pe.edu.upc.spring.model.UserModel;
import pe.edu.upc.spring.service.iAdminService;
import pe.edu.upc.spring.service.iCleaningStaffService;
import pe.edu.upc.spring.service.iClientService;
import pe.edu.upc.spring.service.iUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private iUserService uService;
	
	@Autowired
	private iAdminService aService;
	
	@Autowired
	private iCleaningStaffService csService;
	
	@Autowired
	private iClientService clService;
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("admin", new Admin());
		return "/adminLists/registerAdmin";
	}
	
	@RequestMapping("/staff/list")
	public String goPageListStaff(Map<String, Object> model) {
		model.put("listStaff", csService.listCleaningStaff());
		return "/adminLists/listStaff";
	}
	
	@RequestMapping("/staff/active/{id}")
	public String activeCleaningStaff(@PathVariable int id, Model model, RedirectAttributes objRedir)
			throws ParseException 
			{
				Optional<CleaningStaff> objStaff= csService.findById(id);
				if (objStaff == null) {
					objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				}
				else {
					if(objStaff.isPresent()) {
						objStaff.ifPresent(o -> {
							o.setEnabled(true);
							csService.createCleaningStaff(o);
						});
					}
					
				}
				return "redirect:/admin/staff/list";
			}
	
	@RequestMapping("/prueba")
	public String goPageListAdminprueba(Map<String, Object> model) {
		model.put("listAdmin", aService.listAdmin());
		return "/adminLists/reportPersonal";
	}
	

	@RequestMapping("/prueba1")
	public String goPageListAdminprueba1(Map<String, Object> model) {
		model.put("listAdmin", aService.listAdmin());
		return "/adminLists/reportGeneral";
	}
	
	
	@RequestMapping("/list")
	public String goPageListAdmin(Map<String, Object> model) {
		model.put("listAdmin", aService.listAdmin());
		return "/adminLists/listAdmin";
	}
	
	@RequestMapping("/registerAdmin")
	public String registerClient(@ModelAttribute Admin objAdmin, BindingResult binRes, Model model)throws ParseException{
		if (binRes.hasErrors()) {
			return "registerAdmin";
		} else {
			UserModel user = objAdmin.getUser();
			user.setType_user(new TypeUser(3, "Administrador"));
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			boolean flag = uService.createUser(user);
			if(flag) {
				objAdmin.setUser(user);
				flag = aService.createAdmin(objAdmin);
			} 
			if (flag) {
				return "redirect:/admin/list";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/admin/register"; 
			}
			
		}
		
	}
	
//	@RequestMapping("/clientR")
//	public String goPageReportClient() {
//		//model.put("listClientR", clService.clientReport(1));
//		return "/adminLists/reportClient";
//	}
//	
//	@RequestMapping("/listClient")
//	public String reportClient(Map<String, Object> model) {
//		
//		
//		model.put("listClientR", clService.clientReport());
//		return "/adminLists/reportClient";
//	}
	//public String reportClient(Map<String, Object> model,@PathVariable int mes) {
	
	@RequestMapping("/clientReport")
	public String reportClient(Map<String, Object> model) {
		//System.out.println(mes+"<-");
		model.put("listClientR", clService.clientReport());
		return "/adminLists/reportClient";
	}
	
}
