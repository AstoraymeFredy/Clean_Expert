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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.District;
import pe.edu.upc.spring.model.Property;
import pe.edu.upc.spring.service.iDistrictService;
import pe.edu.upc.spring.service.iPropertyService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iPropertyService pService;
	
	@Autowired
	private iDistrictService dService;
	
	@RequestMapping("/list")
	public String goPageListProperties(Map<String, Object> model) {
		model.put("listProp", pService.findByClientId(sesion.getClient().getId_client()));
		return "/property/listProperties";
	}
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("property", new Property());
		model.addAttribute("district", new District());
		model.addAttribute("listDistrict", dService.listDistrict());
		
		return "/property/Property";
	}
	
	
	@RequestMapping("/registerProperty")
	public String register(@ModelAttribute Property objProperty, BindingResult binRes, Model model)
			throws ParseException
	{
		objProperty.setClient(sesion.getClient());
		if (binRes.hasErrors())
			return "/property/Property";
		else {
			boolean flag = pService.createProperty(objProperty);
			if (flag)
				return "redirect:/property/list";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/property/register";
			}
		}
	}
	
	
	@RequestMapping("/delete")
	public String deleteProperty(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.deleteProperty(id);
				model.put("listProp", pService.findByClientId(sesion.getClient().getId_client()));
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje","La propiedad no se puede eliminar, esta siendo utilizada");
			
			model.put("listProp", pService.findByClientId(sesion.getClient().getId_client()));
		}
		return "listProperties";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String editProperty(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
	{
		Optional<Property> objProperty = pService.findById(id);
		if (objProperty == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/property/list";
		}
		else {
			model.addAttribute("property", objProperty);
			return "property";
		}
	}
	

	
	
	
}