package pe.edu.upc.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

import pe.edu.upc.spring.utils.Sesion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.DetailReservation;
import pe.edu.upc.spring.model.Parameter;
import pe.edu.upc.spring.model.Reservation;
import pe.edu.upc.spring.model.Schedule;
import pe.edu.upc.spring.service.iReservationService;
import pe.edu.upc.spring.service.iDetailReservationService;
import pe.edu.upc.spring.service.iRoomService;
import pe.edu.upc.spring.service.iPropertyService;
import pe.edu.upc.spring.service.iScheduleService;
import pe.edu.upc.spring.service.iParameterService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private Sesion sesion;

	@Autowired
	private iReservationService rService;

	@Autowired
	private iPropertyService pService;

	@Autowired
	private iDetailReservationService dService;

	@Autowired
	private iScheduleService sService;

	@Autowired
	private iRoomService roService;

	@Autowired
	private iParameterService paService;

	List<Parameter> listParameters;
	List<DetailReservation> listDetailReservation;
	List<CleaningStaff> listCleaningStaff;
	Reservation reservation;

	@RequestMapping("/list")
	public String listReservationByClient(Map<String, Object> model) {
		model.put("listReservations", rService.listByClient(sesion.getClient().getId_client()));
		return "/reservation/list";
	}

	@RequestMapping("/view/{id}")
	public String goPageView(@PathVariable int id, Model model, RedirectAttributes objRedir,
			Map<String, Object> modelList) throws ParseException {
		Optional<Reservation> objRes = rService.findById(id);
		if (objRes == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/reservation/list";
		} else {
			if (objRes.isPresent())
				objRes.ifPresent(o -> model.addAttribute("reservation", o));

			modelList.put("listDetailsReservation", dService.listByReservation(id));

			return "reservation/view";
		}
	}

	@RequestMapping("/goRegister")
	public String goPageCreate(Model model) {
		model.addAttribute("listDetailsReservation", roService.listRooms());
		model.addAttribute("listClientStaff", listCleaningStaff);
		model.addAttribute("listProperty", pService.findByClientId(sesion.getClient().getId_client()));
		listParameters = paService.list();
		Reservation objReservation = new Reservation();
		model.addAttribute("reservation", objReservation);
		return "/reservation/create";
	}

	@RequestMapping("/goPayment")
	public String goPageCreate(
			@ModelAttribute("listDetailsReservation") ArrayList<DetailReservation> listDetailsReservation,
			@ModelAttribute Reservation objReservation, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listDetailsReservation", roService.listRooms());
			model.addAttribute("listDetailsReservation", pService.findByClientId(sesion.getClient().getId_client()));
			return "reservation";
		} else {
			this.reservation = objReservation;
			this.listDetailReservation = listDetailsReservation;
			return "/reservation/payment";
		}
	}

	@RequestMapping("/register")
	public String register(Model model, BindingResult binRes) throws ParseException {
		if (binRes.hasErrors()) {
			return "reservation";
		} else {

			boolean flag = true;
			flag = rService.createReservation(this.reservation);

			for (int i = 0; i < this.listDetailReservation.size(); i++) {
				flag = dService.createDetailReservation(this.listDetailReservation.get(i));
			}

			if (flag)
				return "redirect:/reservation/list";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/reservation/goPayment";
			}
		}
	}

	@RequestMapping("/listClientStaff")
	public String listClientStaff(Model model) {
		listCleaningStaff.clear();
		List<Schedule> listSchedule = new ArrayList<Schedule>();

		LocalDate localdate = LocalDate.parse((CharSequence) reservation.getDate());
		Locale spanishLocale = new Locale("es", "ES");
		String dateInSpanish = localdate.format(DateTimeFormatter.ofPattern("EEEE", spanishLocale));
		listSchedule = sService.findHorarioByDate(dateInSpanish);

		List<Reservation> filteredReservations = new ArrayList<Reservation>();
		filteredReservations = rService.listByDate(reservation.getDate());

		List<CleaningStaff> cleaningStaffPerSchedule = new ArrayList<CleaningStaff>();

		for (int i = 0; i < cleaningStaffPerSchedule.size(); i++) {
			if(listSchedule.get(i).getCleaning_staff().isEnabled()) {
				cleaningStaffPerSchedule.add(listSchedule.get(i).getCleaning_staff());
			}
		}

		for (int i = 0; i < cleaningStaffPerSchedule.size(); i++) {
			boolean notFinded = true;
			for (int j = 0; j < filteredReservations.size(); j++) {
				if (filteredReservations.get(i).getCleaningStaff().getId_cleaning_staff() == cleaningStaffPerSchedule
						.get(j).getId_cleaning_staff()) {
					notFinded = false;
				}
			}
			if (notFinded) {
				listCleaningStaff.add(cleaningStaffPerSchedule.get(i));
			}
		}
		model.addAttribute("listClientStaff", listCleaningStaff);

		return "/reservation/create";

	}

}
