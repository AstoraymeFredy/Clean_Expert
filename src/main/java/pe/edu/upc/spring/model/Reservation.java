package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Reserva")
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_reservation;
	
	@NotNull(message = "Ingrese la fecha")
	@Future(message = "La fecha debe estar en el futuro")
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Column(name="precio", nullable=false)
	private float price;
	
	@NotNull(message = "Ingrese la hora de inicio")
	@Column(name="hora_inicio", nullable=false)
	private LocalTime  start_time;
	
	@Column(name="duracion", nullable=false)
	private int duration;
	
	@Column(name="kit_limpieza_extra", nullable=false)
	private boolean extra_cleaning_kit;
	
	@Column(name="estado", nullable=false)
	private String state;
	
	@Transient
	private String card_owner_name;
	
	@Transient
	@Size(min=19, max=19)
	private String card_number;
	
	@Transient
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiration_date;
	
	@Transient
	@Size(min=3, max=3)
	private String cvv_card;
	
	@NotNull(message = "Seleccione personal de limpieza")
	@ManyToOne
	@JoinColumn(name="id_personal_limpieza", nullable=false)
	private CleaningStaff cleaningStaff;
	
	@NotNull(message = "Seleccione propiedad")
	@ManyToOne
	@JoinColumn(name="id_propiedad", nullable=false)
	private Property property;
	
	@Transient
	private List<DetailReservation> listDetails;


	public Reservation() {
		super();
	}

	public Reservation(int id_reservation, Date date, float price, LocalTime start_time, int duration,
			boolean extra_cleaning_kit, String state, String card_owner_name,
			String card_number, Date expiration_date,
			String cvv_card, CleaningStaff cleaningStaff, Property property) {
		super();
		this.id_reservation = id_reservation;
		this.date = date;
		this.price = price;
		this.start_time = start_time;
		this.duration = duration;
		this.extra_cleaning_kit = extra_cleaning_kit;
		this.state = state;
		this.card_owner_name = card_owner_name;
		this.card_number = card_number;
		this.expiration_date = expiration_date;
		this.cvv_card = cvv_card;
		this.cleaningStaff = cleaningStaff;
		this.property = property;
	}

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isExtra_cleaning_kit() {
		return extra_cleaning_kit;
	}

	public void setExtra_cleaning_kit(boolean extra_cleaning_kit) {
		this.extra_cleaning_kit = extra_cleaning_kit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCard_owner_name() {
		return card_owner_name;
	}

	public void setCard_owner_name(String card_owner_name) {
		this.card_owner_name = card_owner_name;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getCvv_card() {
		return cvv_card;
	}

	public void setCvv_card(String cvv_card) {
		this.cvv_card = cvv_card;
	}

	public CleaningStaff getCleaningStaff() {
		return cleaningStaff;
	}

	public void setCleaningStaff(CleaningStaff cleaningStaff) {
		this.cleaningStaff = cleaningStaff;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}


	public List<DetailReservation> getListDetails() {
		return listDetails;
	}

	public void setListDetails(List<DetailReservation> listDetails) {
		this.listDetails = listDetails;
	}

}
