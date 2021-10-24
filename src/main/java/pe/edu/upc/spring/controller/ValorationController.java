package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Valoration;
import pe.edu.upc.spring.service.iValorationService;

@Controller
@RequestMapping("/valoration")
public class ValorationController {
	
	@Autowired
	private iValorationService vService;
	
	@RequestMapping("/list")
	public String goPageListValoration(Map<String, Object> model) {
		model.put("listValorations", vService.list());
		return "/parameter/listValoration";
	}
	//
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("valoration", new Valoration());
		return "/valoration/registerValoration";
	}
	
	@RequestMapping("/registerValoration")
	public String register(@ModelAttribute Valoration objValoration, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors())
			return "valoration";
		else {
			boolean flag = vService.createValoration(objValoration);
			if (flag)
				return "redirect:/valoration/list";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/valoration/register";
			}
		}
	}
}
