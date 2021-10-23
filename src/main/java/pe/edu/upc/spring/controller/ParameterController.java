package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/1")
	public String goPageListParameters(Map<String, Object> model) {
		model.put("listParameters", pService.list());
		return "";
	}
	
	@RequestMapping("/2")
	public String modify(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
		{
			Optional<Parameter> objPar= pService.listId(id);
			if (objPar == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "";
			}
			else {
				model.addAttribute("par", objPar);
				return "parameter";
			}
		}
	
	@RequestMapping("/list")
	public String list(Map<String, Object> model) {
		model.put("listParameters", pService.list());
		return "";
	}	
}
