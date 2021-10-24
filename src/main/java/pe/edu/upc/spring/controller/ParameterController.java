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

import pe.edu.upc.spring.model.Parameter;
import pe.edu.upc.spring.service.iParameterService;

@Controller
@RequestMapping("/parameter")
public class ParameterController {
	
	@Autowired
	private iParameterService pService;
	
	@RequestMapping("/list")
	public String goPageListParameters(Map<String, Object> model) {
		model.put("listParameters", pService.list());
		return "/parameter/listParameter";
	}
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("parameter", new Parameter());
		return "/parameter/Parameter";
	}
	
	@RequestMapping("/registerParameter")
	public String registrar(@ModelAttribute Parameter objParameter, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors())
			return "parameter";
		else {
			boolean flag = pService.createParameter(objParameter);
			if (flag)
				return "redirect:/parameter/list";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/parameter/register";
			}
		}
	}
	
	@RequestMapping("/modify/{id}")
	public String modify(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
		{
			Optional<Parameter> objPar= pService.listId(id);
			if (objPar == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/parameter/list";
			}
			else {
				model.addAttribute("parameter", objPar);
				return "/parameter/Parameter";
			}
		}
}
