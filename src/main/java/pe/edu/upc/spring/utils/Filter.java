package pe.edu.upc.spring.utils;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class Filter {
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_date;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date;
	
	private int id_month;
	
	public Filter() {
		super();
	}

	public Filter(Date start_date, Date end_date, int id_month) {
		super();
		this.start_date = start_date;
		this.end_date = end_date;
		this.id_month = id_month;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getId_month() {
		return id_month;
	}

	public void setId_month(int id_month) {
		this.id_month = id_month;
	}

	
	
}
