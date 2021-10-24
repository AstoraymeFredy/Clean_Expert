package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_schedule;
	
	@Column(name="lunes", nullable=false)
	private boolean monday;
	
	@Column(name="martes", nullable=false)
	private boolean tuesday;
	
	@Column(name="miercoles", nullable=false)
	private boolean wednesday;
	
	@Column(name="jueves", nullable=false)
	private boolean thursday;
	
	@Column(name="viernes", nullable=false)
	private boolean friday;
	
	@Column(name="sabado", nullable=false)
	private boolean saturday;
	
	@Column(name="domingo", nullable=false)
	private boolean sunday;
	
	@OneToOne
	@JoinColumn(name="id_personal_limpieza", nullable=false)
	private CleaningStaff cleaning_staff;
	

	public Schedule() {
		super();
	}


	public Schedule(int id_schedule, boolean monday, boolean tuesday, boolean wednesday, boolean thursday,
			boolean friday, boolean saturday, boolean sunday, CleaningStaff cleaning_staff) {
		super();
		this.id_schedule = id_schedule;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		this.cleaning_staff = cleaning_staff;
	}


	public int getId_schedule() {
		return id_schedule;
	}


	public void setId_schedule(int id_schedule) {
		this.id_schedule = id_schedule;
	}


	public boolean isMonday() {
		return monday;
	}


	public void setMonday(boolean monday) {
		this.monday = monday;
	}


	public boolean isTuesday() {
		return tuesday;
	}


	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}


	public boolean isWednesday() {
		return wednesday;
	}


	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}


	public boolean isThursday() {
		return thursday;
	}


	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}


	public boolean isFriday() {
		return friday;
	}


	public void setFriday(boolean friday) {
		this.friday = friday;
	}


	public boolean isSaturday() {
		return saturday;
	}


	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}


	public boolean isSunday() {
		return sunday;
	}


	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}


	public CleaningStaff getCleaning_staff() {
		return cleaning_staff;
	}


	public void setCleaning_staff(CleaningStaff cleaning_staff) {
		this.cleaning_staff = cleaning_staff;
	}

	
}
