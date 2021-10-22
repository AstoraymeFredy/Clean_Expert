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
	private int id_distrito;
	
	@Column(name="nombre", nullable=false, length=50)
	private String name;

	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	public District(int id_distrito, String name) {
		super();
		this.id_distrito = id_distrito;
		this.name = name;
	}

	public int getId_distrito() {
		return id_distrito;
	}

	public void setId_distrito(int id_distrito) {
		this.id_distrito = id_distrito;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
