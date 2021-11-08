package pe.edu.upc.spring.controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.utils.Sesion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.DetailReservation;
import pe.edu.upc.spring.model.Parameter;
import pe.edu.upc.spring.model.Reservation;
import pe.edu.upc.spring.model.Room;
import pe.edu.upc.spring.model.Schedule;
import pe.edu.upc.spring.service.iReservationService;
import pe.edu.upc.spring.service.iCleaningStaffService;
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

	List<Parameter> listParameters = new ArrayList<Parameter>();
	List<DetailReservation> listDetailReservation = new ArrayList<DetailReservation>();
	List<CleaningStaff> listCleaningStaff= new ArrayList<CleaningStaff>();

	private Reservation reservation;
	

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
		Reservation reservation = new Reservation();

		List<Room> listRoom = roService.listRooms();
		 for (int i = 0; i < listRoom.size(); i++) {
	         DetailReservation detail = new DetailReservation();
	         detail.setRoom(listRoom.get(i));
	         listDetailReservation.add(detail);
	     }
		reservation.setListDetails(this.listDetailReservation);

		model.addAttribute("listClientStaff", listCleaningStaff);
		model.addAttribute("listProperty", pService.findByClientId(sesion.getClient().getId_client()));
		listParameters = paService.list();
		
		this.reservation = reservation;
		model.addAttribute("reservation", reservation);
		return "/reservation/create";
	}

	@RequestMapping("/calculate")
	public String calculate(@ModelAttribute Reservation reservation, BindingResult binRes, Model model) throws ParseException {
			System.out.println("INGRESA");
			/*System.out.println(reservation.getListDetails());
			System.out.println(reservation.getClass().getName());

			int count= 23;

			for (int i = 0; i < reservation.getListDetails().size(); i++) {
				count = count +  reservation.getListDetails().get(i).getQuantity();
			}
			
			this.reservation = reservation;
			
			reservation.setPrice(count);
			model.addAttribute("reservation", reservation);
			
			
			System.out.println(count);
			*/
			return "reservation";
		
	}

	
	@RequestMapping("/goPayment")
	public String goPagePayment(@ModelAttribute Reservation objReservation, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "/reservation/create";
		} else {

	
		System.out.println(objReservation.getDate().toString());
		System.out.println(objReservation.getCleaningStaff().getId_cleaning_staff());

		System.out.println(objReservation.getListDetails().get(0).getQuantity());
		System.out.println(objReservation.getDuration());

		System.out.println(this.listDetailReservation.size());
		System.out.println(objReservation.getPrice());
		System.out.println(objReservation.getListDetails().get(0).getRoom());
		System.out.println(objReservation.getListDetails().get(0).getRoom().getClass().getName());

		this.reservation = objReservation;
		model.addAttribute("reservation", objReservation);

		return "/reservation/create";

	/*	if (binRes.hasErrors()) {
			model.addAttribute("listDetailsReservation", roService.listRooms());
			model.addAttribute("listDetailsReservation", pService.findByClientId(sesion.getClient().getId_client()));
			return "reservation";
		} else {
			this.reservation = objReservation;
			this.listDetailReservation = listDetailsReservation;
			return "/reservation/payment";
		}*/
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

	@ResponseBody
	@RequestMapping("/listClientStaff/{date}")
	public String listStaff(@PathVariable String date, Model model, RedirectAttributes objRedir,
			Map<String, Object> modelList) throws ParseException, java.text.ParseException {
		
			listCleaningStaff.clear();
			List<Schedule> listSchedule = new ArrayList<Schedule>();
	
			LocalDate localdate = LocalDate.parse((CharSequence) date);
			Locale spanishLocale = new Locale("es", "ES");
			String dateInSpanish = localdate.format(DateTimeFormatter.ofPattern("EEEE", spanishLocale));

			listSchedule = sService.findHorarioByDate(dateInSpanish);
	
			List<Reservation> filteredReservations = new ArrayList<Reservation>();
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date_format = format.parse(date);
			filteredReservations = rService.listByDate(date_format);
	
			List<CleaningStaff> cleaningStaffPerSchedule = new ArrayList<CleaningStaff>();
	
			for (int i = 0; i < listSchedule.size(); i++) {

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

			Gson gson = new Gson();
			return gson.toJson(listCleaningStaff);
	}

}
