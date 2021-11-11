package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Distrito")
public class District implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_district;
	
	@Column(name="nombre", nullable=false, length=50)
	private String name;

	public District() {
		super();
	}

	public District(int id_district, String name) {
		super();
		this.id_district  = id_district;
		this.name = name;
	}

	public int getId_district() {
		return id_district;
	}

	public void setId_district(int id_district) {
		this.id_district = id_district;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
